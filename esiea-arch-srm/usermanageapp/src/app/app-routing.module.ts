import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { LoginComponent } from './login/login.component';
import { UserListComponent } from './user-list/user-list.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';



import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { StandardComponent } from './standard/standard.component';
import { AuthGuard } from './_auth/auth.guard';
import { PwdChangeComponent } from './pwd-change/pwd-change.component';


const routes: Routes = [
	{path:'login', component:LoginComponent},
  {path:'create-user', component: CreateUserComponent, canActivate:[AuthGuard], data:{roles:['admin']}},
  {path:'create-account/:id', component: CreateAccountComponent, canActivate:[AuthGuard], data:{roles:['admin']}},
  {path:'users', component: UserListComponent, canActivate:[AuthGuard], data:{roles:['admin']}},
  {path:'', redirectTo: 'users', pathMatch: 'full'},
	{path:'update-user/:id', component: UpdateUserComponent, canActivate:[AuthGuard], data:{roles:['admin']}},
	{path:'user-details/:id', component: UserDetailsComponent, canActivate:[AuthGuard], data:{roles:['admin']}},
	
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['admin']} },
  { path: 'standard', component: StandardComponent, canActivate:[AuthGuard], data:{roles:['standard']} },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'pwd-change', component: PwdChangeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
