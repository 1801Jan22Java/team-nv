import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar-buttons',
  templateUrl: './sidebar-buttons.component.html',
  styleUrls: ['./sidebar-buttons.component.css']
})
export class SidebarButtonsComponent implements OnInit {

  constructor(private route:Router) {


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

  ngOnInit() {
  }

}
