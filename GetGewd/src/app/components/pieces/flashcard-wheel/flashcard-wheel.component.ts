import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flashcard-wheel',
  templateUrl: './flashcard-wheel.component.html',
  styleUrls: ['./flashcard-wheel.component.css']
})
export class FlashcardWheelComponent implements OnInit {
  private things:any;

  constructor() {
    
    
   }

   Cards(){
      this.things =[{question:"blerp",answer:"bloop",hint:"blap"},{question:"blerp",answer:"bloop",hint:"blap"},{question:"blerp",answer:"bloop",hint:"blap"}];

      console.log(this.things[0].question);
      console.log(this.things[0].answer);
      var question = document.createTextNode(this.things[0].question);
      var answer = document.createTextNode(this.things[0].answer);
      //var holder = document.createElement("p");
      //holder.appendChild(question);
      document.getElementById("container").appendChild(question);
   }
   nextCard(){

   }

   previousCard (){

   }

   showCard(){
     
   }

  ngOnInit() {
    this.Cards();
  
  }
}
