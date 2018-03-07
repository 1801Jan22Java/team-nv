import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../core/auth.service';
import { Router } from '@angular/router';
import { FlashcardService } from '../../../flashcard.service';
import { Flashcard } from '../../../flashcard';
import { User } from '../../../user';

@Component({
  selector: 'app-flashcard-wheel',
  templateUrl: './flashcard-wheel.component.html',
  styleUrls: ['./flashcard-wheel.component.css']
})
export class FlashcardWheelComponent implements OnInit {
  private things: any;
  private position: number = 0;
  private uriId: number;  // same as groupId
  private flashcards: Flashcard[];
  private user: User;
  private uid: string;
  private tagName:string;

  constructor(private router: Router, private flashcardService: FlashcardService, private authService: AuthService, private httpClient: HttpClient) {
  }

  /*
  Cards(){
    // this.things =[{question:"blerp",answer:"bloop",hint:"blap"},{question:"blerpy",answer:"bloop",hint:"blap"},{question:"blerpest",answer:"bloop",hint:"blap"}];
     
    
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

  } */
  Learned(){
    var thingObject = {
      userId:this.uid,
       //need to set current tag name
      tagName:null,
      isCorrect:true,
    }
    this.httpClient.post('http://localhost:8080/Project2/user/updateProgress',thingObject).subscribe();
  }
  Learning(){
    var thingObject = {
      userId:this.uid,
      //need to set current tag name 
      tagName:null,
      isCorrect:false,

    }
    this.httpClient.post('http://localhost:8080/Project2/user/updateProgress',thingObject).subscribe();
  }


  ngOnInit() {
    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));
    console.log(this.uriId);

    this.flashcardService.getFlashcardsByGroupId(this.uriId).subscribe((flashcards: Flashcard[]) => {
      this.flashcards = flashcards
      console.log(this.flashcards);
    });

    this.authService.user.subscribe((user: User) => {
      this.user = user;
      this.uid = this.user.uid;
      console.log(this.uid);
    });

    //this.Cards()


  }

}
