import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { User } from '../model/user';
import { API_BASE_URL, ACCESS_TOKEN } from '../constants/constants';
import { map } from 'rxjs/operators';
import { LoginRequest } from '../model/loginRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(email: string, password: string) {
    let loginRequest: LoginRequest = {
      email: email,
      password: password
    }

    return this.http.post<any>(API_BASE_URL + "/auth/login", loginRequest)
      .pipe(map(token => {
        // login successful if there's a jwt token in the response
        console.log(token);
        if (token.accessToken) {
          console.log("AAAAAA"+ token.accessToken);
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem(ACCESS_TOKEN, token.accessToken);
        }
      }));
  }

  getCurrentUser() {
    if (!localStorage.getItem(ACCESS_TOKEN)) {
      return Promise.reject("No access token set.");
    }
    return this.http.get<any>(API_BASE_URL + "/user/me").pipe(map(user => {
      this.currentUserSubject.next(user)
    }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
