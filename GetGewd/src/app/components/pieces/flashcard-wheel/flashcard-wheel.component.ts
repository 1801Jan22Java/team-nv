import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../core/auth.service';
import{HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-flashcard-wheel',
  templateUrl: './flashcard-wheel.component.html',
  styleUrls: ['./flashcard-wheel.component.css']
})
export class FlashcardWheelComponent implements OnInit {
  private things:any;
  private position:number = 0;

  constructor(public auth: AuthService,private httpClient:HttpClient) {    
   }

   Cards(){
      this.things =[{question:"blerp",answer:"bloop",hint:"blap"},{question:"blerpy",answer:"bloop",hint:"blap"},{question:"blerpest",answer:"bloop",hint:"blap"}];

      var question = document.createTextNode(this.things[0].question);
      //var holder = document.createElement("p");
      //holder.appendChild(question);
      document.getElementById("container").appendChild(question);
      console.log(this.position);
   }
   nextCard(){
     console.log("things is "+this.things.length)
     if(this.position == this.things.length-1){
       this.position = 0
       console.log("got here 0")
     }else{
     this.position += 1;
     console.log("got here 1")
     }

     console.log(this.position);
     //var holder = document.createElement("p");
     //holder.appendChild(question);
     document.getElementById("container").innerHTML =this.things[this.position].question;
   }

   previousCard (){
    if(this.position = 0){
      this.position = this.things.length;
    }
    this.position -= 1;

    console.log(this.position);
    var question = document.createTextNode(this.things[this.position].question);
    //var holder = document.createElement("p");
    //holder.appendChild(question);
    document.getElementById("container").innerHTML =this.things[this.position].question;
   }

   showCard(){
   
    //var holder = document.createElement("p");
    //holder.appendChild(question);
    document.getElementById("container").innerHTML =this.things[this.position].answer;

   }
   showHint(){
   
    //var holder = document.createElement("p");
    //holder.appendChild(question);
    document.getElementById("container").innerHTML =this.things[this.position].hint;

   }

  ngOnInit() {

  
  }
}
