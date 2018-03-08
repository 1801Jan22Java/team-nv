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

  user: User;
  uid: string;
  groups: Group[];

  constructor(private authService: AuthService, private groupService: GroupService) { }

  ngOnInit() {
    this.uid = localStorage.getItem("uid");
    console.log(this.uid);
    this.groupService.getGroupsByUid(this.uid).subscribe((groups: Group[]) => {
      this.groups = groups
      //console.log(this.groups);
    });

  }

}
