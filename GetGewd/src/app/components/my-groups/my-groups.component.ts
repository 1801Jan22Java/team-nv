import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { User } from '../../user'
import { GroupService } from '../../group.service'
import { Group } from '../../group'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-my-groups',
  templateUrl: './my-groups.component.html',
  styleUrls: ['./my-groups.component.css']
})
export class MyGroupsComponent implements OnInit {

  private user: User;
  private groups: Group[];
  private uid: string;

  constructor(private authService: AuthService, private groupService: GroupService) { }

  ngOnInit() {
    this.authService.user.subscribe((user: User) => {
      this.user = user;
      this.uid = this.user.uid;
      console.log(this.uid);
    });

    // below method should be switched to this.user.uid as argument
    this.groupService.getGroupsByUid("userTest1").subscribe((groups: Group[]) => {
      this.groups = groups
      console.log(this.groups);
    });
    
  }

}
