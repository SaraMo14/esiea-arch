import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account';
import { UserAuthService } from './user-auth.service';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  
  requestHeader = new HttpHeaders(
    {"No-Auth": "True",
    'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
  );
  
  constructor(
    private httpClient: HttpClient,
    private userAuthService: UserAuthService,
    private userService: UserService
    
  ) { 
    
  }
  changePassword(account: Account) {
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",      
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.post("http://localhost:8080/api/v1/account/changePassword", account, {headers: reqHeader});
  }
  resetPassword(username: string) {
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
   
    return this.httpClient.post("http://localhost:8080/api/v1/account/reset", username, {headers: reqHeader});
  }

  deleteAccount(username: string): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.delete("http://localhost:8080/api/v1/deleteAccount/" + username, {headers: reqHeader});
  }

  deactivateAccount(username: string): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.get("http://localhost:8080/api/v1/deactivate/" + username, {headers:reqHeader});
  }

  activateAccount(username: string): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.get("http://localhost:8080/api/v1/activate/" + username, {headers: reqHeader});
  }

  createAccount(account: Account): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    if(account.type!='admin'){
      account.type="standard";
    }
    return this.httpClient.post("http://localhost:8080/api/v1/createAccount", account, {headers: reqHeader});
  }

  getAccountByUsername(username: string): Observable<Account>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.get<Account>("http://localhost:8080/api/v1/account/"+username, {headers: reqHeader});
  }

}
