import { User } from "./user";

export class Account {
	username!:string;
	password!:string;
	creationDate!:string;
	userID!: number;
	endDate!:string;
	activated!: boolean;
	type!:string;
	/*constructor(username:string, password:string, creationDate:string, user:string, endDate:string, activated:string,type:string){
		this.username=username;
		this.password=password;
		this.creationDate=creationDate;
		this.user=user;
		this.endDate=endDate;
		this.activated=activated;
		this.type=type;
	}*/
	
	constructor(){	}
}
