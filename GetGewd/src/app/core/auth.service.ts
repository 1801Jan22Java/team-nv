import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import * as firebase from 'firebase/app';
import { AngularFireAuth } from 'angularfire2/auth';
import { AngularFirestore, AngularFirestoreDocument } from 'angularfire2/firestore';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/switchMap'
import { User } from '../user'

// interface User {
//  uid: string;
//  email: string;
//  photoURL?: string;
//  displayName?: string;
//  favoriteColor?: string;
//}


@Injectable()
export class AuthService {
   things:string;
  user: Observable<User>;

  //userid: String;

  constructor(private afAuth: AngularFireAuth,
    private afs: AngularFirestore,
    private router: Router) {

    //// Get auth data, then get firestore user document || null
    this.user = this.afAuth.authState
      .switchMap(user => {
        if (user) {
          return this.afs.doc<User>(`users/${user.uid}`).valueChanges()
        } else {
          return Observable.of(null)
        }
      })
  }

  /** Added after lunch email login **/
  signInRegular(email, password) {
    const credential = firebase.auth.EmailAuthProvider.credential(email, password);
    return this.afAuth.auth.createUserWithEmailAndPassword(email, password);
  }

  googleLogin() {
    const provider = new firebase.auth.GoogleAuthProvider()
    return this.oAuthLogin(provider);
  }

  private oAuthLogin(provider) {
    return this.afAuth.auth.signInWithPopup(provider)
      .then((credential) => {
        this.updateUserData(credential.user)
      })
  }


  private updateUserData(user) {
    // Sets user data to firestore on login

    const userRef: AngularFirestoreDocument<any> = this.afs.doc(`users/${user.uid}`);

    const data: User = {
      uid: user.uid,
      email: user.email,
      displayName: user.displayName,
      photoURL: user.photoURL
    }

    return userRef.set(data, { merge: true })

  }
  updateItems(){
    this.user.subscribe(data => this.setitem(data.displayName))
  }
  setitem(abc){
    this.things = abc;
   
  }

  getitem():String{
    return this.things;
  }

  signOut() {
    this.afAuth.auth.signOut().then(() => {
        this.router.navigate(['login']);
    });
  }

}