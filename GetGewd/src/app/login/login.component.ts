import { Component, OnInit } from '@angular/core';
import { AuthService } from '../core/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',

  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  user = {
   email: '',
   password: ''
  };

  signInWithEmail() {
   this.auth.signInRegular(this.user.email, this.user.password)
      .then((res) => {
         console.log(res);
   
         this.router.navigate(['dashboard']);
      })
      .catch((err) => console.log('error: ' + err));
  }
  constructor(public auth: AuthService) { }

  ngOnInit() {
  }

}
