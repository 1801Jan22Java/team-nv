import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { GroupService } from '../../group.service'
import { Group } from '../../group'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-all-groups',
  templateUrl: './all-groups.component.html',
  styleUrls: ['./all-groups.component.css']
})
export class AllGroupsComponent implements OnInit {

  private groups: Group[];

  constructor(private authService: AuthService, private groupService: GroupService) { }

  ngOnInit() {
    this.groupService.getAllGroups().subscribe((groups: Group[]) => {
      this.groups = groups
      console.log(this.groups);
    });
  }

}
