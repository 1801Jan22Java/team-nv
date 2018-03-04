import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { User } from '../../user'

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private authService: AuthService) { }

  private user: User;

  ngOnInit() {
    this.authService.user.subscribe((user: User) => {
      this.user = user

      console.log(this.user.uid);

      
    });
    
  };
}
