import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  accounts: Account[] = []
  username!: string
  id!: number
  constructor(private userService: UserService, private accountService: AccountService,
     private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.accounts = new Array<Account>();
    this.id = this.route.snapshot.params['id'];

    this.userService.getAccounts(this.id).subscribe(data =>{
      this.accounts = data;
      for (let account of this.accounts){
        var endDate = new  Date (account.endDate);
        var currentDate = new Date();
        if(endDate<=currentDate){
          //console.log(endDate.toDateString());
          this.accountService.deactivateAccount(account.username).subscribe( data => {
          });
        }
      }
    });
  }


  deactivateAccount(username: string){
    this.accountService.deactivateAccount(username).subscribe( data => {
    });
    this.router.navigate(['users']);
  }

  activateAccount(username: string){
    this.accountService.activateAccount(username).subscribe( data => {
    });
    this.router.navigate(['users']);
  }

  deleteAccount(username: string){
    this.accountService.deleteAccount(username).subscribe( data => {
      console.log(data);

    });
    this.router.navigate(['users']);
  }


  resetPassword(username: string){
    this.accountService.resetPassword(username).subscribe( data => {

    });
    this.router.navigate(['users']);

  }
}
