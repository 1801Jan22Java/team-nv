import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { JoinPageComponent } from './components/join-page/join-page.component';
import { ProgressPageComponent } from './components/progress-page/progress-page.component';
import { CreateGroupPageComponent } from './components/create-group-page/create-group-page.component';

const routes: Routes =[
	{ path: '', redirectTo: '/login', pathMatch: 'full'},
	{path: 'login', component: LoginComponent},
  {path:'homepage',component:HomePageComponent},
  {path:'joinPage',component:JoinPageComponent},
  {path:'createGroup',component:CreateGroupPageComponent},
  {path:'progress',component:ProgressPageComponent},
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
