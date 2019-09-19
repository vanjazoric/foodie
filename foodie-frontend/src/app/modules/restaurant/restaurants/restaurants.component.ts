import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { RestaurantCategory } from 'src/app/model/restaurant-category';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  restaurants: any;
  category: string;
  defaultLogo: string = '/assets/img/restaurant-logo.jpg';

  constructor(private route: ActivatedRoute, private restaurantService: RestaurantService) { }

  getRestaurants(category: number) {
    this.restaurantService.getRestaurants(category).subscribe(
      data => {
        this.restaurants = data;
        console.log(data);
        this.category = <RestaurantCategory>RestaurantCategory[this.restaurants[0].category];
      },
      error => {
        console.log('Oops! Something went wrong. Please try again!');
      });
  }

  ngOnInit() {
    var category = this.route.snapshot.params['category'];
    this.getRestaurants(category);
  }

}
