import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  account: Account = new Account();
  user: User = new User();
  user_id!: number;
  flag: boolean = true;
  //today: string = formatDate(new Date(), 'yyyy/MM/dd', 'en');
  
  constructor(private userService: UserService, 
    private accountService: AccountService,
    private router: Router,  private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.user_id = this.route.snapshot.params['id'];
    this.userService.getUserById(this.user_id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
  }

  saveAccount(){
    this.account.userID=this.user_id;
    this.account.activated = true;
    this.accountService.createAccount(this.account).subscribe( data =>{
      console.log(data);
      this.goToUserList();
    },
    error => console.log(error));
  }
  goToUserList(){
    this.router.navigate(['/users']);
  }
  onSubmit(){
    console.log(this.user);
    this.saveAccount();
  }


}
