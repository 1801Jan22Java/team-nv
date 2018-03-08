import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../../core/auth.service';
import { User } from '../../../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-flashcard-form',
  templateUrl: './add-flashcard-form.component.html',
  styleUrls: ['./add-flashcard-form.component.css']
})
export class AddFlashcardFormComponent implements OnInit {
  private uriId: number;  // same as groupId
  private user: User;
  private uid: string;
  

  constructor(private http: HttpClient, private auth: AuthService, private router: Router) { }

  onSubmit(Form: NgForm) {
    // need to post 
    var cardObject = {
      groupId: this.uriId,
      question: Form.value.question,
      answer: Form.value.answer,
      hint: Form.value.hint,
      //might need to change so only existing tags are possible
      tagName: Form.value.tag,

    }



    cardObject.groupId = this.uriId;
   console.log(cardObject);
    this.http.post('http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/group/addFlashcard', cardObject).subscribe();

  }
  ngOnInit() {
    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));
    
  }

}
