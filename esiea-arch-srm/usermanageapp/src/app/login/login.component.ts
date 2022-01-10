import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Account } from '../account';
import { RegistrationService} from '../registration.service';
import { UserService} from '../user.service';
import { UserAuthService} from '../user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
account = new Account();
msg= '';
  constructor(
	private _service : RegistrationService, 
	private _route : Router, 
	private userAuthService: UserAuthService) { }

  ngOnInit(): void {
  }
	
  loginUser(){
	this._service.loginUserFromRemote(this.account).subscribe(
		(response: any) => {
			//console.log(this.account);
			//this._route.navigate(['/home'])
			this.userAuthService.setType(response.account.type);
			this.userAuthService.setToken(response.jwtToken);
			this.userAuthService.setUsername(response.account.username);
			const role = response.account.type; 
			if (role === 'admin') {
				this._route.navigate(['/admin']);
			} else {
				this._route.navigate(['/standard']);
			}
		},
		(error) => {
			console.log(this.account);
			console.log("exception occured" + error);
			this.msg="Bad credentials, please enter valid username and password";
		},
	);
}
}
