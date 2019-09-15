import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { ModalModule } from '../modal/modal.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    RestaurantComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ModalModule,
    ReactiveFormsModule
  ]
})
export class RestaurantModule { }
