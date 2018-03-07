import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';
import { GroupService } from '../../group.service'
import { Group } from '../../group'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../../user';

@Component({
  selector: 'app-group-home',
  templateUrl: './group-home.component.html',
  styleUrls: ['./group-home.component.css']
})
export class GroupHomeComponent implements OnInit {

  private uriId: number;  // same as groupId
  private group: Group;
  private user: User;
  private uid: string;

  constructor(private router: Router, private authService: AuthService, private groupService: GroupService) { }

  goToAddFlashcards(){
    this.router.navigate(['addFlashcards'])
  }

  ngOnInit() {
    this.authService.user.subscribe((user: User) => {
      this.user = user;
      this.uid = this.user.uid;
      console.log(this.uid);
    });
    
    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));
    console.log(this.uriId);

    this.groupService.getGroupByGroupId(this.uriId).subscribe((group: Group) => {
      this.group = group
      console.log(this.group);
    });

    // post request here to add user to group, if not a part of the group already
  }  
}
