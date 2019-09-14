import { Component, OnInit } from '@angular/core';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import { ItemService } from '../../../services/item.service';
import { Item } from '../../../model/item';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  categories: string[];
  selectedCategory: number;
  faStar = faStar;
  popularItems: Item[] = [];
  firstRow: Item[] = [];
  secondRow: Item[] = [];
  thirdRow: Item[] = [];

  constructor(private itemService: ItemService) {
    this.getMostPopularItems();
    this.categories = new Array("Domaća kuhinja", "Brza hrana",
      "Kineski restoran", "Italijanski restoran", "Vegetarijanski restoran", "Poslastičarnica");
  }

  getMostPopularItems() {
    this.itemService.getMostPopularItems()
      .subscribe(
        data => {
          this.popularItems = data;
          this.getFirstRow();
          this.getSecondRow();
          this.getThirdRow();
        },
        error => {
          console.log('Oops! Something went wrong. Please try again!');
        });
  }

  getFirstRow() {
    for (let index = 0; index < 3; index++) {

      this.firstRow.push(this.popularItems[index]);
      console.log(this.popularItems[2]);
    }
  }

  getSecondRow() {
    for (let index = 3; index < 6; index++) {
      this.secondRow.push(this.popularItems[index]);
    }
  }

  getThirdRow() {
    for (let index = 6; index < 9; index++) {
      this.thirdRow.push(this.popularItems[index]);
    }
  }

  ngOnInit() {
  }

}
