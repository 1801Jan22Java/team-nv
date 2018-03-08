import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';

import { Group } from './group'

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class GroupService {

  getAllGroupsURL = 'http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/group/all';

  constructor(private http: HttpClient) { }

/*  getAllGroups(): Observable<Group[]> {
    return this.httpClient.get<Group[]>('http://localhost:8080/Project2/group/all');     
  }*/

  getAllGroups(): Observable<Group[]> {
    return this.http.get<Group[]>(this.getAllGroupsURL);
  }

  getGroupsByUid(uid: String): Observable<Group[]> {
    return this.http.get<Group[]>(`http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/user/group/${uid}`); 
  }

  getGroupByGroupId(uriId: number): Observable<Group> {
    return this.http.get<Group>(`http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/group/${uriId}`); 
  }
}
