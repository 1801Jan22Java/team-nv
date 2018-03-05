import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../core/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(public auth: AuthService, private route:Router ) { }

  traveHome(){
    this.route.navigate(["/homepage"]);
  }

  travelMyGroups(){
    
  }
  travelAddFlashcard(){
    this.route.navigate(["/addFlashcards"]);

  }
  ngOnInit() {
  }

}
