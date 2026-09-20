import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
  ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  email = '';
  password = '';

  private readonly router = inject(Router);

  login(){
    if(this.email == ''){
      return;
    }

    if(this.password == ''){
      return;
    }

    this.router.navigate(['/dashboard'])
  }

  continueWithGoogle(){
    this.router.navigate(['/dashboard'])
  }

}
