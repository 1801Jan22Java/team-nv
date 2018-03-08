import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { User } from '../../user';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  
  user: User;
  uid: string;
  
  constructor(private authService: AuthService) { }
  
  ngOnInit() { 
    this.authService.user.subscribe((user: User) => {
      this.user = user;
      this.uid = this.user.uid;
      console.log(this.uid);
      localStorage.setItem("uid", this.uid);
      });
  }
}
