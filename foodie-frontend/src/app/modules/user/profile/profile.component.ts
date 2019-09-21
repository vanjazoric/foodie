import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: User = null;
  orders: any;

  constructor(private authService: AuthService, private router: Router, private orderService: OrderService) { }

  ngOnInit() {
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    if (this.currentUser == null) {
      this.router.navigate(['/login']);
    }
    this.getAllOrders();
  }

  getAllOrders() {
    this.orderService.getOrders().subscribe(data => {
      console.log(data);
      this.orders = data;

    },
      error => {
        console.log('Oops! Something went wrong. Please try again!');
      });
  }

}
