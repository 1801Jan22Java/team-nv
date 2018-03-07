import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { JoinPageComponent } from './components/join-page/join-page.component';
import { ProgressPageComponent } from './components/progress-page/progress-page.component';
import { CreateGroupPageComponent } from './components/create-group-page/create-group-page.component';
import { AllGroupsComponent } from './components/all-groups/all-groups.component';
import { MyGroupsComponent } from './components/my-groups/my-groups.component';
import { GroupHomeComponent } from './components/group-home/group-home.component';
import {AddFlashcardPageComponent} from "./components/add-flashcard-page/add-flashcard-page.component";
import { FlashcardPageComponent } from './components/flashcard-page/flashcard-page.component';

const routes: Routes =[
	{ path: '', redirectTo: '/login', pathMatch: 'full'},
	{path: 'login', component: LoginComponent},
  {path:'homepage',component:HomePageComponent},
  {path:'joinPage',component:JoinPageComponent},
  {path:'createGroup',component:CreateGroupPageComponent},
  {path:'progress',component:ProgressPageComponent},
  {path:'allgroups',component:AllGroupsComponent},
  {path:'mygroups',component:MyGroupsComponent},
  {path:'grouphome/:group.groupId',component:GroupHomeComponent},
  {path:'addFlashcards', component:AddFlashcardPageComponent},
  {path: 'flashcards/:group.groupId', component: FlashcardPageComponent},
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
