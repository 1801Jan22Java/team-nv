import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/auth.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  constructor(public auth: AuthService, private router: Router, private httpClient: HttpClient) { }

  //groupNames,percentages
  createGraph(info) {
    for (var j = 0; j < info.length; j++) {
      let tagNames = info[j].tagName;
      let numCorrect = info[j].numCorrect;
      let numAnswered = info[j].numAnswered;
      
      
      let percentages = (numCorrect/numAnswered)*100;


        let box = document.createElement("div");
        let wording = document.createElement("p");
        let words = document.createTextNode(tagNames);
        wording.appendChild(words);
        wording.setAttribute("style", "color:white");
        box.id = "stuff";
        box.setAttribute("style", `position:absolute;width:12%;height:${percentages}%;background:black;bottom:0%;left:${13 * j}%`);
        box.appendChild(wording);

        document.getElementById("things").appendChild(box);
      
    }
  }
  ngOnInit() {
    this.auth.user.subscribe(data1 => {
      this.httpClient.get(`http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/user/progress/${data1.uid}`).subscribe((data: any[]) => {
        console.log(data);
        console.log(data1.uid)

        this.createGraph(data);

      })
    })



  }
}
