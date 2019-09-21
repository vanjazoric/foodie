import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/auth/login/login.component';
import { OAuth2Component } from './modules/auth/oauth2/oauth2.component';
import { HomeComponent } from './modules/home/home/home.component';
import { RestaurantComponent } from './modules/restaurant/restaurant/restaurant.component';
import { ShoppingCartComponent } from './modules/order/shopping-cart/shopping-cart.component';
import { ProfileComponent } from './modules/user/profile/profile.component';
import { RestaurantsComponent } from './modules/restaurant/restaurants/restaurants.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'oauth2/redirect',
    component: OAuth2Component
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'restaurant/:id',
    component: RestaurantComponent
  },
  {
    path: 'restaurants/:category',
    component: RestaurantsComponent
  },
  {
    path: 'shopping-cart',
    component: ShoppingCartComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
