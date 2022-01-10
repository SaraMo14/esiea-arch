import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { HeaderComponent } from '../header/header.component';
import { User } from '../user';
import { UserAuthService } from '../user-auth.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username!: string
  user!: User
  account!: Account
  constructor(private route: ActivatedRoute, 
    private userService: UserService,
    public accountService: AccountService,
    private userAuthService: UserAuthService,
    private router: Router) { }

  ngOnInit(): void {
    this.username = this.userAuthService.getUsername();
    console.log(this.account);
    this.account = new Account();
    this.accountService.getAccountByUsername(this.username).subscribe( data => {
      this.account = data;
      console.log(this.account);
    });

  }

  public isLoggedIn(){
    return this.userAuthService.isLoggedIn();
  }
}
