import { Injectable } from '@angular/core';
import { Account } from './account';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http : HttpClient) { }
  
  public loginUserFromRemote(account :Account):Observable<any>{
	  return this._http.post<any>("http://localhost:8080/authenticate", account);
  }
}
