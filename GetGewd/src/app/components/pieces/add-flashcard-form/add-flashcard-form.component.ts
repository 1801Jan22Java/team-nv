import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';
import{HttpClient} from '@angular/common/http';
import { AuthService } from '../../../core/auth.service';

@Component({
  selector: 'app-add-flashcard-form',
  templateUrl: './add-flashcard-form.component.html',
  styleUrls: ['./add-flashcard-form.component.css']
})
export class AddFlashcardFormComponent implements OnInit {

  constructor(private http:HttpClient,private auth:AuthService) { }

  onSubmit(Form:NgForm){
    // need to post 
    console.log(Form.value);
  // this.http.post("http://localhost:8080/Project2/user/addUser",Form.value).subscribe();
   /*
   this.auth.user.subscribe(data =>{
     groupObject.leaderId = data.uid;
     //console.log(groupObject);
     this.httpClient.post("http://localhost:8080/Project2/group/addGroup",groupObject).subscribe();
   })
   this.router.navigate(["/homepage"]);*/
  }
  ngOnInit() {
  }

}
