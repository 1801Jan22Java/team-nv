import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';
import { GroupService } from '../../group.service'
import { Group } from '../../group'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../../user';
import { Http } from '@angular/http';

@Component({
  selector: 'app-group-home',
  templateUrl: './group-home.component.html',
  styleUrls: ['./group-home.component.css']
})
export class GroupHomeComponent implements OnInit {

  uriId: number;  // same as groupId
  group: Group;
  user: User;
  uid: string;
  leaderId: string;

  constructor(private router: Router, private authService: AuthService, private groupService: GroupService, private http: HttpClient) { }

  goToAddFlashcards() {
    this.router.navigate([`addFlashcards/${this.uriId}`])
  }

  ngOnInit() {
    this.uid = localStorage.getItem("uid");
    console.log(this.uid);

    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));
    //console.log(this.uriId);

    this.groupService.getGroupByGroupId(this.uriId).subscribe((group: Group) => {
      this.group = group
      this.group.groupLeader = this.leaderId;
      //console.log(this.group);
      // console.log(this.group);
    });

    var userObject = {
      groupId: this.uriId,
      userId: this.uid,
    }

    console.log(userObject);
    this.http.post("http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/group/addUser", userObject).subscribe()
    // post request here to add user to group, if not a part of the group already

  }
}
