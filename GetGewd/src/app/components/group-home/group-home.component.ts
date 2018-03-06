import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';
import { GroupService } from '../../group.service'
import { Group } from '../../group'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-group-home',
  templateUrl: './group-home.component.html',
  styleUrls: ['./group-home.component.css']
})
export class GroupHomeComponent implements OnInit {

  private uriId: number;  // same as groupId
  private group: Group;

  constructor(private router: Router, private authService: AuthService, private groupService: GroupService) { }

  ngOnInit() {
    let uri: string = this.router.url;
    this.uriId = parseInt(uri.substring(uri.lastIndexOf('/') + 1));
    console.log(this.uriId);

    this.groupService.getGroupByGroupId(this.uriId).subscribe((group: Group) => {
      this.group = group
      console.log(this.group);
    });
  }

  // method to have user join group IF user is not already a part of the group (similar to addUser post)
  // method for checking if group leader (to determine if review cards button will show)
  // method to load previous pages information

}
