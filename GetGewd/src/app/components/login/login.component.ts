import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';
import{HttpClient} from '@angular/common/http';


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
  
  constructor(public auth: AuthService, private router: Router,private httpClient:HttpClient) { 
  }

  signInWithGoogle() {
  	this.auth.googleLogin()
  	.then((res) => {
      this.auth.user.subscribe(data => {this.httpClient.post("http://localhost:8080/Project2/user/addUser",data.uid).subscribe();

    
    });
      this.router.navigate(['homepage']);
      
  	})
  	.catch((err) => console.log(err)); 
  }

  signInWithEmail() {
    this.auth.signInRegular(this.user.email, this.user.password)
      .then((res) => {
      })
      .catch((err) => console.log('error: ' + err));
      this.auth.user.subscribe(data =>{
        this.httpClient.post("http://localhost:8080/Project2/user/addUser",data.uid).subscribe();
      })
      this.router.navigate(['homepage']);
  }

   ngOnInit() {
  }

}
