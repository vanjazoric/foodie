import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [SignUpComponent, ProfileComponent],
  imports: [
    CommonModule
  ]
})
export class UserModule { }
