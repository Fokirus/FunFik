import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogOverviewExampleDialog } from './authorization/authorization.component';
import { DialogForRegistration } from './registration/registration.component';

export interface DialogData {
  username: string;
  password: string;
  email: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FanFik-FE';
  
  username: string = "";
  password: string = "";
  email: string = "";

  constructor(public dialog: MatDialog) {}
  
  openLoginDialog(): void{
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: {username: this.username, password: this.password}
    });
  
      dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.password = result;
    });
  }

  openRegistrationDialog(): void{
    const dialogRef = this.dialog.open(DialogForRegistration, {
      height: '450px',
      width: '250px',
      data: {username: this.username, password: this.password, email: this.email}
    });
  
      dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.password = result;
    });
  }
}
