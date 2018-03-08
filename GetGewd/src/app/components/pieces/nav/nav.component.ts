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

  travelHome(){
    this.route.navigate(["/homepage"]);
  }

  travelMyGroups(){
    this.route.navigate(["/mygroups"]);
  }
  travelAddFlashcard(){
    this.route.navigate(["/addFlashcards"]);

  }
  goToProgress(){
    console.log("got here");
    this.route.navigate(['progress']);
  }

  goToCreateGroup(){
   this.route.navigate(['createGroup']);
  }

  goToAllGroup(){
   this.route.navigate(['allgroups']);
  }

 /* 
  travelFlashcard(){
    this.route.navigate(["/flashcards"]);

  }
  */
  ngOnInit() {
  }

}
