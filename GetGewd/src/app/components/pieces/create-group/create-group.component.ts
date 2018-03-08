import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';
import{HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/auth.service';


@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})
export class CreateGroupComponent implements OnInit {
  name:string = "";
  constructor(private httpClient:HttpClient,private router:Router,public auth: AuthService) {
    
   }

  onSubmit(heroForm:NgForm){
    var groupObject ={
      groupName:heroForm.value.id,
      groupDescription:heroForm.value.description,
      leaderId:null,
    }
  console.log(heroForm.value.description);
    
    console.log(heroForm.value);
    this.auth.user.subscribe(data =>{
      groupObject.leaderId = data.uid;
      console.log(groupObject);
      this.httpClient.post("http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/group/addGroup",groupObject).subscribe();
    })
    this.router.navigate(["/homepage"]);
    
  }
  
 // this.router.navigate(['homepage']);



  ngOnInit() {
  }
}
// router garud prevents users from going to certain paiges 
//this.httpClient.get(`http://localhost:8080/team-nv/Project2/user/group/all`).subscribe((data:any[]) => {
  //console.log(data);