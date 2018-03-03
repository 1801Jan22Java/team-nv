import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Group } from './group';
import { GROUP } from './mock-group'

//import { HttpClient, HttpHeaders } from '@angular/common/http';

// this service is currently using dummy data
@Injectable()
export class GroupFlashcardsService {

  userId: number;
  groupId: number;

  constructor(private httpClient: HttpClient) { }

  // this would be get request
  getGroup() {
    return this.httpClient.get('http://localhost:8080/Project2/group/1'); //=> {
  }

    // this would be get request
    //getGroup(): Observable<any[]> {
    //  return this.httpClient.get('http://localhost:8080/Project2/group/1').subscribe(data:any[]); //=> {
        //console.log(data);
      //return of(GROUP);
    //}

  //getHeroes(): Observable<Hero[]> {
    // Todo: send the message _after_ fetching the heroes
    //return of(HEROES);
  //}

  // this would be get request
  // getFlashcards(): Observable<Group> {
  //  return of(group);
  // }
}
