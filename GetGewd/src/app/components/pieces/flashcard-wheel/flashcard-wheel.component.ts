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
  private position: number = 0;
  private uriId: number;  // same as groupId
  flashcards: Flashcard[];
  private user: User;
  private uid: string;
  private question: string;
  private hint: string;
  private answer: string;
  private tag: string;
  private  thingObject = {
    userId:this.uid,
    tagName:this.tag,
    isCorrect:true,
  }


  constructor(private router: Router, private flashcardService: FlashcardService, private authService: AuthService, private httpClient: HttpClient) {
  }

  ngOnInit() {
    // get groupId
    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));

    // get uid
    this.authService.user.subscribe((user: User) => {
      this.user = user;
      this.uid = this.user.uid;
    
    
    // get flashcards
    this.flashcardService.getFlashcardsByGroupId(this.uriId).subscribe((flashcards: Flashcard[]) => {
      this.flashcards = flashcards;
      this.tag = this.flashcards[this.position].tag.tagName;
      this.question = this.flashcards[this.position].question;
      this.hint = this.flashcards[this.position].hint;
      this.answer = this.flashcards[this.position].answer;
    });
  });

  }

  onYes() {
    this.learned();
    this.hideHintAndAnswer();
    this.nextCard();
  }

  onNo() {
    this.learning();
    this.hideHintAndAnswer();
    this.nextCard();
  }
  
  learned(){
    this.thingObject.userId=this.uid,
    this.thingObject.tagName=this.tag,
    this.thingObject.isCorrect=true,

    console.log("uid is "+this.uid);
    console.log(this.tag);
    this.httpClient.post('http://localhost:8080/Project2/user/updateProgress',this.thingObject).subscribe();
  }

  learning(){
    this.thingObject.userId=this.uid,
    this.thingObject.tagName=this.tag,
    this.thingObject.isCorrect=false,
    console.log(this.thingObject);
    console.log("uid is "+this.uid);
    this.httpClient.post('http://localhost:8080/Project2/user/updateProgress',this.thingObject).subscribe();
  }

  hideHintAndAnswer() {
    document.getElementById("hint").style.opacity = "0";
    document.getElementById("answer").style.opacity = "0";
  }

  showHint() {
    document.getElementById("hint").style.opacity = "1";
  }
  
  showAnswer() {
    document.getElementById("answer").style.opacity = "1";
  }

  nextCard() {
    //console.log("flashcards is " + this.flashcards.length)
    if (this.position === this.flashcards.length - 1) {
      this.position = 0;
    } else {
      this.position += 1;
    }
    this.tag = this.flashcards[this.position].tag.tagName;
    this.question = this.flashcards[this.position].question;
    this.hint = this.flashcards[this.position].hint;
    this.answer = this.flashcards[this.position].answer;
  }

  previousCard() {
    if (this.position === 0) {
      this.position = this.flashcards.length - 1;
    } else {
      this.position -= 1;
    }
    this.tag = this.flashcards[this.position].tag.tagName;
    this.question = this.flashcards[this.position].question;
    this.hint = this.flashcards[this.position].hint;
    this.answer = this.flashcards[this.position].answer;
  }
  
}
