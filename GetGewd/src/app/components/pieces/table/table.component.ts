import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  constructor() { }

  
  createGraph(){
        let things = [0, 5, 10];        
        let box = document.createElement("div");
        box.id = "stuff";
        box.setAttribute("style","position:absolute;width:200px;height:20%;background:black;top:50%");
        
        document.getElementById("things").appendChild(box);
       
      }
    
  

  

  ngOnInit() {
    this.createGraph();

}
}
