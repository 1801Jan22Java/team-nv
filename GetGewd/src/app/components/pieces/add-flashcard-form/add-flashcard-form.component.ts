import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';
import{HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add-flashcard-form',
  templateUrl: './add-flashcard-form.component.html',
  styleUrls: ['./add-flashcard-form.component.css']
})
export class AddFlashcardFormComponent implements OnInit {

  constructor(private http:HttpClient) { }

  onSubmit(heroForm:NgForm){
    // need to post 
   this.http.post("http://localhost:8080/Project2/user/addUser",heroForm.value).subscribe();
  }
  ngOnInit() {
  }

}
