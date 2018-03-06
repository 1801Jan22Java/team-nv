import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flashcard-wheel',
  templateUrl: './flashcard-wheel.component.html',
  styleUrls: ['./flashcard-wheel.component.css']
})
export class FlashcardWheelComponent implements OnInit {

  constructor() {
    
    
   }

   reviewCards(){
      let things=[{question:"blerp",answer:"bloop",hint:"blap"},{question:"blerp",answer:"bloop",hint:"blap"},{question:"blerp",answer:"bloop",hint:"blap"}]

      var question = document.createTextNode(things[0].question);
      var answer = document.createTextNode(things[0].answer);
      document.getElementById("Container").appendChild(question);
   }

  ngOnInit() {

  
  }
}
