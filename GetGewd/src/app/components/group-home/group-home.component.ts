import { Component, OnInit } from '@angular/core';

import { Group } from '../../group';

import { GroupFlashcardsService } from '../../group-flashcards.service'

@Component({
  selector: 'app-group-home',
  templateUrl: './group-home.component.html',
  styleUrls: ['./group-home.component.css']
})
export class GroupHomeComponent implements OnInit {

  group: any;
  // group: Group;  // no longer need Group class?
  

  constructor(private groupFlashcardsService: GroupFlashcardsService) { }

  ngOnInit() {
    this.getGroup();
  }

  getGroup(): void {    // subscribe currently returning an object
    this.groupFlashcardsService.getGroup().subscribe(group => this.group = group)    
    //this.groupFlashcardsService.getGroup().subscribe(group => this.group = group)
  }

  // method that checks if logged in user's uid, matches the groupleader id in current group
}
