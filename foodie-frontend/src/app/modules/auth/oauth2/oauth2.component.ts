import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { ACCESS_TOKEN } from '../../../constants/constants';

@Component({
  selector: 'app-oauth2',
  templateUrl: './oauth2.component.html',
  styleUrls: ['./oauth2.component.css']
})
export class OAuth2Component implements OnInit {

  subscription: Subscription;
  token: string;
  error: string;

  constructor(private route: ActivatedRoute, private router: Router, private authService:AuthService) { }

  ngOnInit() {
    this.subscription = this.route
      .queryParams
      .subscribe(params => {
        this.token = params['token'];
        this.error = params['error'];
      });


    if (this.token) {
      localStorage.setItem(ACCESS_TOKEN, this.token);
      this.authService.getCurrentUser().subscribe();
      this.router.navigate(['/home']);
    } else {
      console.log("error while getting token from oath2");
    }
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}