import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { Router } from '@angular/router';
import { FlashcardService } from '../../flashcard.service';
import { Flashcard } from '../../flashcard';
import { User } from '../../user';

@Component({
  selector: 'app-flashcard-page',
  templateUrl: './flashcard-page.component.html',
  styleUrls: ['./flashcard-page.component.css']
})
export class FlashcardPageComponent implements OnInit {
  constructor() { }

  ngOnInit() {
    

  }

}
