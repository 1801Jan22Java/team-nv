import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';
import{HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})
export class CreateGroupComponent implements OnInit {
  constructor(private httpClient:HttpClient) { }
  name:string = '';
  onSubmit(heroForm:NgForm){
      this.name = heroForm.value;
  }

  getProfile(){

  }

  ngOnInit() {
  }
}
