import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';

import { Group } from './group'

@Injectable()
export class GroupService {

  constructor(private httpClient: HttpClient) { }

  getAllGroups(): Observable<Group[]> {
    return this.httpClient.get<Group[]>('http://localhost:8084/Project2/group/all');     
  }

  getGroupsByUid(uid: String): Observable<Group[]> {
    return this.httpClient.get<Group[]>(`http://localhost:8084/Project2/user/group/${uid}`); 
  }

  getGroupByGroupId(uriId: number): Observable<Group> {
    return this.httpClient.get<Group>(`http://localhost:8084/Project2/group/${uriId}`); 
  }
}
