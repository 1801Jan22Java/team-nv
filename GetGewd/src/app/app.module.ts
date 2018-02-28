import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
/** import AngularFire **/
import { AngularFireModule } from 'angularfire2';

/** export firebaseConfig **/
export const firebaseConfig = {
	apiKey: '',
	authDomain: '',
	databaseURL: '',
	storageBucket: '',
	messagingSenderId: ''
};

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmailComponent } from './email/email.component';
import { SignupComponent } from './signup/signup.component';
import { MembersComponent } from './members/members.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmailComponent,
    SignupComponent,
    MembersComponent
  ],
  imports: [
    BrowserModule,
    // Firebase  modules
    FormsModule,
    HttpModule,
    AngularFireModule.initializeApp(firebaseConfig)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
