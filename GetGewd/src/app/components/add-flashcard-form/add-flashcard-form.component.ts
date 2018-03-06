import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-add-flashcard-form',
  templateUrl: './add-flashcard-form.component.html',
  styleUrls: ['./add-flashcard-form.component.css']
})
export class AddFlashcardFormComponent implements OnInit {

  constructor() { }

  onSubmit(heroForm:NgForm){
    console.log(heroForm.value);
      
  }
  ngOnInit() {
  }

}
