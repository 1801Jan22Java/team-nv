import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  constructor() { }

  ngOnInit() {
    var things = [0, 5, 10];
    var graphContext = document.getElementById("graphContainer");
      for (let i = 0; i < things.length; i++) {
        document.createElement("div").setAttribute("style", "width:200px;height:200px;background-color:black");
        console.log("got here");
      }
    
  }

}
