import { Component, OnInit } from '@angular/core';
import { OrderItem } from 'src/app/model/orderItem';
import { Item } from 'src/app/model/item';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { ModalService } from 'src/app/services/modal.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/model/user';
import { Order } from 'src/app/model/order';
import { OrderService } from 'src/app/services/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderItems: OrderItem[] = null;
  message: string;
  restaurantMap: any = new Map<String, OrderItem[]>();
  amount: number;
  currentUser: User = null;
  note: string;
  restaurantName: string;
  error: boolean = null;

  constructor(private modalService: ModalService, private orderService: OrderService, private authService: AuthService, private router: Router) { }

  openModal(restName: string) {
    this.restaurantName = restName;
    this.amount = 0;
    var listOfItems = this.restaurantMap.get(restName);
    listOfItems.forEach(element => {
      this.amount += (element.quantity * element.itemPrice);
    });
    this.modalService.open("create-order-modal");
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  createOrder(restName: string) {
    if (this.currentUser == null) {
      this.router.navigate(['/login']);
    }
    var order = new Order();
    order.amount = this.amount;
    order.note = this.note;
    order.userAddress = this.currentUser.address;
    order.userPhone = this.currentUser.phoneNumber;
    order.orderItems = this.restaurantMap.get(restName)
    this.orderService.createOrder(order)
      .subscribe(
        data => {
          this.restaurantMap.delete(restName);
          var currentItems = JSON.parse(localStorage.getItem('orderItems'));
          currentItems = currentItems.filter(function (obj) {
            return obj.restaurantName !== restName;
          });
          localStorage.setItem('orderItems', JSON.stringify(currentItems));
          this.error = false;
        },
        error => {
          console.log('Oops! Something went wrong. Please try again!');
          this.error = true;
        });
    this.closeModal('create-order-modal');
  }

  ngOnInit() {

    this.authService.currentUser.subscribe(x => this.currentUser = x);

    this.orderItems = JSON.parse(localStorage.getItem('orderItems'));
    if (this.orderItems == null || this.orderItems.length == 0) {
      this.message = "Nemate nijedan artikal u korpi.";
    }

    let restaurants = []; // Lista koja ce sadrzati sve razlicite nazive restorana

    for (let index = 0; index < this.orderItems.length; index++) {
      if (restaurants.indexOf(this.orderItems[index].restaurantName) == -1) {
        restaurants.push(this.orderItems[index].restaurantName);
      }
    }

    for (let i = 0; i < restaurants.length; i++) {
      for (let j = 0; j < this.orderItems.length; j++) {

        if (this.orderItems[j].restaurantName == restaurants[i]) {
          var list = [];
          if (this.restaurantMap.get(restaurants[i])) {
            list = this.restaurantMap.get(restaurants[i]);
          }
          list.push(this.orderItems[j]);
          this.restaurantMap.set(restaurants[i], list);
        }
      }
    }
  }
}