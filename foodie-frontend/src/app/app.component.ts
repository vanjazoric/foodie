import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { User } from './model/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-app';

  currentUser: User = null;;

  constructor(
    private router: Router,
    private authService: AuthService
  ) {
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  logout() {
    //?
    this.currentUser = null;
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}