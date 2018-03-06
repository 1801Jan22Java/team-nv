import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { User } from '../../user'
import { GroupService } from '../../group.service'
import { Group } from '../../group'

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private authService: AuthService, private groupService: GroupService) { }

  private user: User;
  private groups: Group[];

  ngOnInit() {
    //this.authService.user.subscribe((user: User) => {
    //  this.user = user

    //  console.log(this.user.uid);

      this.groupService.getAllGroups().subscribe((groups: Group[]) => {
        this.groups = groups
        console.log(this.groups);
      });

      


      //console.log(this.groupService.getGroupsByUid(this.user.uid));

    //});
  };

}
