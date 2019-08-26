import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/auth/login/login.component';
import { OAuth2Component } from './modules/auth/oauth2/oauth2.component';

const routes: Routes = [
  { path: 'login', 
    component: LoginComponent 
  },
  {
    path: 'oauth2/redirect',
    component: OAuth2Component
  }/*,
  { path: 'dashboard',
    component: DashboardComponent
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
