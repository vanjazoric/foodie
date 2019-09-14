import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ACCESS_TOKEN, API_BASE_URL, CURRENT_USER } from '../constants/constants';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }

  getMostPopularItems() {
    return this.http.get<any>(API_BASE_URL + "/items/popular");
  }
}
