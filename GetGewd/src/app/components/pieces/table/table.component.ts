import { Component, OnInit } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/auth.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  constructor(public auth: AuthService, private router: Router,private httpClient:HttpClient) { }

  //groupNames,percentages
  createGraph() {
    let groupNames = ["biology", "physics", "math"];
    let percentages = [100, 50, 25];
    
    
    for (var i = 0; i < percentages.length; i++) {
      let box = document.createElement("div");
      let wording = document.createElement("p");
      let words = document.createTextNode(groupNames[i]);
      wording.appendChild(words);
      wording.setAttribute("style","color:white");
      box.id = "stuff";
      box.setAttribute("style", `position:absolute;width:12%;height:${percentages[i]}%;background:black;bottom:0%;left:${13*i}%`);
      box.appendChild(wording);
      
      document.getElementById("things").appendChild(box);
    }
  }
  ngOnInit() {
   // this.httpClient.get(`http://localhost:8080/team-nv/Project2/user/group/all`).subscribe((data:any[]) => {
      //console.log(data);
      // get cards b
 // })
 this.createGraph();

  }
}
