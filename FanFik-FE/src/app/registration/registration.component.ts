import {Component, Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { AuthService } from '../core/services/http/auth.service';

export interface DialogData {
  username: string;
  password: string;
  email: string;
}

@Component({
    selector: 'registration-component',
    templateUrl: 'registration.component.html',
    providers: [AuthService]
  })
  export class DialogForRegistration {
    username: string = "";
    password: string = "";
    email: string = "";
  
    constructor(
      public dialogRef: MatDialogRef<DialogForRegistration>,
      @Inject(MAT_DIALOG_DATA) public data: DialogData,
      private authService: AuthService) {}
      
    onClickRegistration(): void {
      this.authService.registration(this.username, this.email, this.password).subscribe(() => {
        this.dialogRef.close;
      },
      (error) => {
        console.error(error);
      });
    }
  }