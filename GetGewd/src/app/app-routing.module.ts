import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { JoinPageComponent } from './components/join-page/join-page.component';
import { ProgressPageComponent } from './components/progress-page/progress-page.component';
import { CreateGroupPageComponent } from './components/create-group-page/create-group-page.component';
import {AddFlashcardPageComponent} from "./components/add-flashcard-page/add-flashcard-page.component";
import { FlashcardPageComponent } from './components/flashcard-page/flashcard-page.component';

const routes: Routes =[
	{ path: '', redirectTo: '/login', pathMatch: 'full'},
	{path: 'login', component: LoginComponent},
  {path:'homepage',component:HomePageComponent},
  {path:'joinPage',component:JoinPageComponent},
  {path:'createGroup',component:CreateGroupPageComponent},
  {path:'progress',component:ProgressPageComponent},
  {path:'addFlashcards', component:AddFlashcardPageComponent},
  {path: 'flashcards', component: FlashcardPageComponent},
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
