import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { Router } from '@angular/router';



import{Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
 stuff:string;
  constructor(public auth: AuthService,private router: Router) {

      
    
   }

  ngOnInit() {

    this.auth.updateItems();
    console.log("hello " +this.auth.getitem());
   /* 
   this.afAuth.authState.switchMap(
    auth =>{
      console.log(auth.uid);
      return this.db.object('users/' +auth.uid)
    }else{
      return Observable.of(null)
    }
  })*/
  
  }

}
