import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { StandardComponent } from './standard/standard.component';
import { AdminComponent } from './admin/admin.component';
import { RouterModule } from '@angular/router';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { AuthGuard } from './_auth/auth.guard';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { PwdChangeComponent } from './pwd-change/pwd-change.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserListComponent,
    CreateUserComponent,
    UpdateUserComponent,
    UserDetailsComponent,
    HeaderComponent,
    ForbiddenComponent,
    HomeComponent,
    StandardComponent,
    AdminComponent,
    AccountListComponent,
    CreateAccountComponent,
    PwdChangeComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
    AppRoutingModule,
    RouterModule,
    Ng2SearchPipeModule
  ],
  providers: [/*AuthGuard,{
    provide: HTTP_INTERCEPTORS, 
    useClass: AuthInterceptor,
    multi: true
  }*/],
  bootstrap: [AppComponent]
})
export class AppModule { }
