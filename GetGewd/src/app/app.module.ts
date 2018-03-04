import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CoreModule } from './core/core.module';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { AppComponent } from './app.component';
import { environment } from '../environments/environment';
import { AngularFireModule } from 'angularfire2';
import { AngularFirestoreModule } from 'angularfire2/firestore';
import { AngularFireStorageModule } from 'angularfire2/storage';
import { AngularFireAuthModule } from 'angularfire2/auth';

import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

import { NavComponent } from './components/pieces/nav/nav.component';
import { ProfileComponent } from './components/pieces/profile/profile.component';
import { ProfileSidebarComponent } from './components/pieces/profile-sidebar/profile-sidebar.component';
import { SidebarButtonsComponent } from './components/pieces/sidebar-buttons/sidebar-buttons.component';
import { JoinGroupTableComponent } from './components/pieces/join-group-table/join-group-table.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { JoinPageComponent } from './components/join-page/join-page.component';
import { CreateGroupComponent } from './components/pieces/create-group/create-group.component';
import { CreateGroupPageComponent } from './components/create-group-page/create-group-page.component';
import { TableComponent } from './components/pieces/table/table.component';
import { ProgressPageComponent } from './components/progress-page/progress-page.component';
import { GroupHomeComponent } from './components/group-home/group-home.component';
import { GroupFlashcardsService } from './group-flashcards.service';
import { AuthService } from './core/auth.service';
//import { UidService } from './uid.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NavComponent,
    ProfileComponent,
    ProfileSidebarComponent,
    SidebarButtonsComponent,
    JoinGroupTableComponent,
    HomePageComponent,
    JoinPageComponent,
    CreateGroupComponent,
    CreateGroupPageComponent,
    TableComponent,
    ProgressPageComponent,
    ProgressPageComponent,
    GroupHomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebase, 'GetGewd'),
    AngularFireAuthModule,
    AngularFirestoreModule,
    AngularFireStorageModule,
    HttpClientModule,
    HttpModule,
  ],
  providers: [
    GroupFlashcardsService,
    //UidService,
    AuthService,
    /* . . . */
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
