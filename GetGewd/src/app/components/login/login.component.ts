import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  constructor(public auth: AuthService, private router: Router) { 
  }

  signInWithGoogle() {
  	this.auth.googleLogin()
  	.then((res) => {
  		this.router.navigate(['homepage'])
  	})
  	.catch((err) => console.log(err)); 
  }

/*  signInWithEmail() {
    this.authService.signInRegular(this.user.email, this.user.password)
      .then((res) => {
        console.log(res);
        this.router.navigate(['userhome']);
      })
      .catch((err) => console.log('error: ' + err));
  }*/

}
