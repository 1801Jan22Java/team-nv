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

  private uriId: number;  // same as groupId
  private flashcards: Flashcard[];
  private user: User;
  private uid = String;

  constructor(private router: Router, private flashcardService: FlashcardService, private authService: AuthService) { }

  ngOnInit() {
    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));
    console.log(this.uriId);

    this.flashcardService.getFlashcardsByGroupId(this.uriId).subscribe((flashcards: Flashcard[]) => {
      this.flashcards = flashcards
      console.log(this.flashcards);
    });

    this.authService.user.subscribe((user: User) => {
      this.user = user
      console.log(this.user.uid);
    
      // write code here
    
    });

  }

}
