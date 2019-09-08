import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { User } from './model/user';
import { ACCESS_TOKEN } from './constants/constants';
import { Router } from '@angular/router';
import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-app';
  faSignOut = faSignOutAlt;

  currentUser: User = null;;

  constructor(
    private router: Router,
    private authService: AuthService
  ) {
    if (localStorage.getItem(ACCESS_TOKEN)) {
      this.authService.getCurrentUser().subscribe();
    }
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    console.log(this.currentUser);
  }

  logout() {
    //?
    this.currentUser = null;
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}