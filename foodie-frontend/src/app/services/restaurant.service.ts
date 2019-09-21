import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_BASE_URL } from '../constants/constants';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http: HttpClient) { }

  getRestaurant(id: number) {
    return this.http.get<any>(API_BASE_URL + "/restaurants/" + id);
  }

  getRestaurants(category: number) {
    return this.http.get<any>(API_BASE_URL + "/restaurants/category/" + category);
  }
}