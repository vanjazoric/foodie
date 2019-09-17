import { Component, OnInit } from '@angular/core';
import { OrderItem } from 'src/app/model/orderItem';
import { Item } from 'src/app/model/item';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderItems: OrderItem[] = null;
  message: string;
  restaurantMap: any = new Map<String, OrderItem[]>();

  constructor() { }

  ngOnInit() {
    this.orderItems = JSON.parse(localStorage.getItem('orderItems'));
    if (this.orderItems == null) {
      this.message = "Nemate nijedan artikal u korpi.";
    }

    let restaurants = []; // Lista koja ce da sadrzi sve razlicite restorane npr: ress. = ['Sabiadoro', 'Minuta', 'Petrus']

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
    console.log(this.restaurantMap);
  }
}