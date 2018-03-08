import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Flashcard } from './flashcard';

@Injectable()
export class FlashcardService {

  constructor(private httpClient: HttpClient) { }

  getFlashcardsByGroupId(uriId: number): Observable<Flashcard[]> {
    return this.httpClient.get<Flashcard[]>(`http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/group/flashcard/${uriId}`); 
  }
  
}
