import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './modules/home/home.module';
import { JwtInterceptor } from './interceptors/JwtInterceptor';
import { AuthModule } from './modules/auth/auth.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ModalModule } from './modules/modal/modal.module';
import { RestaurantModule } from './modules/restaurant/restaurant.module';
import { UserModule } from './modules/user/user.module';
import { OrderModule } from './modules/order/order.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AuthModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    HomeModule,
    ModalModule,
    UserModule,
    RestaurantModule,
    OrderModule
  ],
  providers: [/*{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  }*/
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
