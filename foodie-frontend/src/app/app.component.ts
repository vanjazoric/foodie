import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { User } from './model/user';
import { ACCESS_TOKEN, CURRENT_USER } from './constants/constants';
import { Router } from '@angular/router';
import { faSignOutAlt, faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-app';
  faSignOut = faSignOutAlt;
  faProfile = faUser;
  currentUser: User = null;;
  defaultImage:string='/assets/img/avatar.png';

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
    this.currentUser = null;
    localStorage.removeItem(ACCESS_TOKEN)
    localStorage.removeItem(CURRENT_USER)
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}