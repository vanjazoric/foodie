import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/auth/login/login.component';
import { OAuth2Component } from './modules/auth/oauth2/oauth2.component';
import { HomeComponent } from './modules/home/home/home.component';
import { RestaurantComponent } from './modules/restaurant/restaurant/restaurant.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
