import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user'
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users?: User[];
  filterTerm!: string;

  //userRecords!: User[] //...
  
  constructor (private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
      this.getUsers();
  }


  userDetails(id: number){
    this.router.navigate(['user-details', id]);
  }

  private getUsers(){
    this.userService.getUsersList().subscribe(data => {
      this.users = data;
    });
  }

  updateUser(id: number){
    this.router.navigate(['update-user', id]);
  }

  deleteUser(id: number){
    this.userService.deleteUser(id).subscribe( data => {
      console.log(data);
      this.getUsers();
    })
  }
  

  createAccount(id: number){
    this.router.navigate(['create-account', id]);
  }
}
