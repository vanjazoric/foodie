import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_BASE_URL } from '../constants/constants';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  createOrder(order: Order) {
    return this.http.post<any>(API_BASE_URL + "/orders/create", order);
  }

  getOrders(){
    return this.http.get<any>(API_BASE_URL + "/orders");
  }
}