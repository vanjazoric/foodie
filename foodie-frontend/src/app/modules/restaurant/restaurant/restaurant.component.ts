import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantCategory } from 'src/app/model/restaurant-category';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ModalService } from '../../../services/modal.service';
import { Item } from 'src/app/model/item';
import { OrderItem } from 'src/app/model/orderItem';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  restaurant: Restaurant;
  restaurantId: number;
  category: string;
  defaultLogo: string = '/assets/img/restaurant-logo.jpg';
  restaurantLogo: string = null;
  form: FormGroup;
  item: Item;
  orderItems: OrderItem[] = [];

  constructor(private route: ActivatedRoute, private modalService: ModalService, private restaurantService: RestaurantService, private fb: FormBuilder) { }

  getRestaurant() {
    this.restaurantService.getRestaurant(this.restaurantId).subscribe(
      data => {
        this.restaurant = data;
        //this.restaurantLogo = '/assets/img/' + this.restaurant.logo;
        this.category = <RestaurantCategory>RestaurantCategory[this.restaurant.category];
        console.log(this.restaurant.foodItems)
      },
      error => {
        console.log('Oops! Something went wrong. Please try again!');
      });
  }

  openModal(itemId: number) {
    this.item = this.restaurant.foodItems.find(x => x.id == itemId);
    this.modalService.open("restaurant-item-modal");
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  addToCart(id: string) {
    var orderItem = new OrderItem();
    orderItem.itemId = this.item.id;
    orderItem.itemName = this.item.name;
    orderItem.itemPrice = this.item.price;
    orderItem.restaurantId = this.restaurant.id;
    orderItem.restaurantName = this.restaurant.name;
    orderItem.quantity = this.form.get('quantity').value;

    var storage = JSON.parse(localStorage.getItem('orderItems'));
    if (storage == null) {
      this.orderItems.push(orderItem);
      localStorage.setItem('orderItems', JSON.stringify(this.orderItems));
    }
    else {
      storage.push(orderItem);
      localStorage.setItem('orderItems', JSON.stringify(storage));
    }

    this.closeModal('restaurant-item-modal');
  }


  ngOnInit() {
    this.restaurantId = this.route.snapshot.params['id'];
    this.getRestaurant();
    this.form = this.fb.group({
      quantity: ['', [Validators.required, Validators.pattern("^[0-9]*$")]]
    });
  }
}
