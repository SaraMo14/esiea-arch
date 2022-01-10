import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { UserAuthService } from '../user-auth.service';

@Component({
  selector: 'app-pwd-change',
  templateUrl: './pwd-change.component.html',
  styleUrls: ['./pwd-change.component.css']
})
export class PwdChangeComponent implements OnInit {

  

  account!: Account;
  

  constructor(private route: ActivatedRoute, 
    private userAuthService: UserAuthService, 
    private accountService: AccountService,
    private router: Router) { }

  ngOnInit() {
    this.account = new Account();
    this.account.username = this.userAuthService.getUsername();
		}
  changePassword() {
    console.log('Working on changing password');
    this.accountService.changePassword(this.account).subscribe(() => {
      console.log("success");
      console.log('Password Changed');
    }, error => {
      console.log(error);
      console.log('Unable to change password');
    });

    this.router.navigate(['/home']);
  }


}
