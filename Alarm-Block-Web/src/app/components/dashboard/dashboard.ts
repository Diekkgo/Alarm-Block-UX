import { Component } from '@angular/core';
import { RouterModule, RouterLink } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  imports: [
    RouterModule,
    RouterLink
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {

}
