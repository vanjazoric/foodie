import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { ModalModule } from '../modal/modal.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RestaurantsComponent } from './restaurants/restaurants.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    RestaurantComponent,
    RestaurantsComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ModalModule,
    ReactiveFormsModule,
    RouterModule
  ]
})
export class RestaurantModule { }
