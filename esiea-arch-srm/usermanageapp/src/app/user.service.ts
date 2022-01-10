import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';
import { Account } from './account';
import { UserAuthService } from './user-auth.service';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  requestHeader = new HttpHeaders(
    {"No-Auth": "True",
    'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
  );
  
  constructor(
    private httpClient: HttpClient,
    private userAuthService: UserAuthService
    
  ) { }

  getUsersList(): Observable<User[]>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.get<User[]>("http://localhost:8080/api/v1/all", {headers: reqHeader});
  }

  createUser(user: User): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.post("http://localhost:8080/api/v1/createUser", user, {headers: reqHeader});
  }

  getUserById(id: number): Observable<User>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.get<User>("http://localhost:8080/api/v1/users/"+id, {headers: reqHeader});
  }

  updateUser(id: number, user: User): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.put("http://localhost:8080/api/v1/updateUser/" + id, user, {headers: reqHeader});
  }

  deleteUser(id: number): Observable<Object>{
    let reqHeader = new HttpHeaders(
      {"No-Auth": "True",
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
    );
    return this.httpClient.delete("http://localhost:8080/api/v1/deleteUser/" + id, {headers: reqHeader});
  }

  public roleMatch(allowedRoles: string): boolean {
    let isMatch = false;
    const userRole: any = this.userAuthService.getType();
    if (userRole != "{}") {
          if (userRole == allowedRoles) {
            isMatch = true;
          } 
        return isMatch;
      }
      throw new Error("Shouldn't be reachable");

    }




    //account
    getAccounts(id: number): Observable<Account[]>{
      let reqHeader = new HttpHeaders(
        {"No-Auth": "True",
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' +  this.userAuthService.getToken()}
      );
      return this.httpClient.get<Account[]>("http://localhost:8080/api/v1/accounts/" + id, {headers: reqHeader});
    }

}
