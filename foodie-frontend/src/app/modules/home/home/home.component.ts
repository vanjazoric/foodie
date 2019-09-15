import { Component, OnInit } from '@angular/core';
import { faStar, faUtensils } from '@fortawesome/free-solid-svg-icons';
import { ItemService } from '../../../services/item.service';
import { Item } from '../../../model/item';
import { ModalService } from '../../../services/modal.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrderItem } from 'src/app/model/orderItem';
import { empty } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  categories: string[];
  selectedCategory: number;
  faStar = faStar;
  faUtensils = faUtensils;
  popularItems: Item[] = [];
  bodyText: string;
  item: Item;
  form: FormGroup;
  orderItems: OrderItem[] = [];

  constructor(private itemService: ItemService, private modalService: ModalService, private fb: FormBuilder) {
    this.getMostPopularItems();
    this.categories = new Array("Domaća kuhinja", "Brza hrana",
      "Kineski restoran", "Italijanski restoran", "Vegetarijanski restoran", "Poslastičarnica");
  }

  getMostPopularItems() {
    this.itemService.getMostPopularItems()
      .subscribe(
        data => {
          this.popularItems = data;
          console.log(data);
        },
        error => {
          console.log('Oops! Something went wrong. Please try again!');
        });
  }

  openModal(id: number) {
    this.item = this.popularItems.find(x => x.id === id)
    console.log(this.item);
    this.modalService.open("home-item-modal");
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  addToCart(id: string) {
    var orderItem = new OrderItem();
    orderItem.itemId = this.item.id;
    orderItem.itemName = this.item.name;
    orderItem.itemPrice = this.item.price;
    orderItem.restaurantId = this.item.restaurantId;
    orderItem.restaurantName = this.item.restaurantName;
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

    this.closeModal('home-item-modal');
    console.log(id);
    console.log(this.item);
  }

  ngOnInit() {
    this.form = this.fb.group({
      quantity: ['', [Validators.required, Validators.pattern("^[0-9]*$")]]
    });
  }

}
