import { newArray } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Account } from '../account';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  id!: number
  user!: User
  //accounts: Account[] = []
  constructor(private route: ActivatedRoute, 
    private userService: UserService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    //this.accounts = new Array<Account>();
    this.userService.getUserById(this.id).subscribe( data => {
      this.user = data;
    });

    /*this.userService.getAccounts(this.id).subscribe(data =>{
      this.accounts = data;
    })*/

  }

}
