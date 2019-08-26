import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { API_BASE_URL, ACCESS_TOKEN } from '../constants/constants';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  singUp(user: User) {
    return this.http.post(API_BASE_URL + "/auth/signup", user);
  }
/*
  getAll() {
    return this.http.get<User[]>(`${config.apiUrl}/users`);
  }

  getById(id: number) {
    return this.http.get(`${config.apiUrl}/users/${id}`);
  }

  update(user: User) {
    return this.http.put(`${config.apiUrl}/users/${user.id}`, user);
  }

  delete(id: number) {
    return this.http.delete(`${config.apiUrl}/users/${id}`);
  }*/
}