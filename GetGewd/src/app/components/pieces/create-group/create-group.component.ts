import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';
import{HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})
export class CreateGroupComponent implements OnInit {
  name:string = "";
  constructor(private httpClient:HttpClient,private router:Router) {
    
   }

  onSubmit(heroForm:NgForm){
    console.log(heroForm.value);
     this.httpClient.get(`http://ec2-34-229-145-42.compute-1.amazonaws.com:8080/team-nv/Project2/user/flashcard/userTest2`).subscribe((data:any[]) => {
      console.log(data);
      
  })
  
  //this.router.navigate(['homepage']);
}


  ngOnInit() {
  }
}
// router garud prevents users from going to certain paiges 