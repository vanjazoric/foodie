import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ModalModule } from '../modal/modal.module';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    FormsModule,
    FontAwesomeModule,
    RouterModule,
    ModalModule,
    ReactiveFormsModule
  ]
})
export class HomeModule { }
