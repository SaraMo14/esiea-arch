import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setType(role: string){
    localStorage.setItem("type", JSON.stringify(role));
  }

  public getType(): string{
    return JSON.parse(localStorage.getItem("type")|| '{}');
  }
  
  public setUsername(username: string){
    localStorage.setItem("username", JSON.stringify(username));
  }

  public setUserID(id: number){
    localStorage.setItem("userID", JSON.stringify(id));
  }

  public getUserID(): number{
    return JSON.parse(localStorage.getItem("userID")|| '{}');
  }

  public getUsername(): string{
    return JSON.parse(localStorage.getItem("username")|| '{}');
  }

  public setToken(jwtToker: string=""){
    localStorage.setItem("jwtToken", jwtToker);
  }

  public getToken(): string{
    return localStorage.getItem("jwtToken")|| '{}';
  }

  public clear(){
    localStorage.clear();
  }

  public isLoggedIn(){
    return this.getType() && this.getToken();
  }
}
