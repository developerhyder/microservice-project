import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { MatDialog } from '@angular/material/dialog';
import { ServiceAdminComponent } from '../service-admin/service-admin.component';
import { ProfileComponent } from '../profile/profile.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent{

  displayHeader: string='';
  title = 'frontend';
  displayContent: string="Service IT";
  lenOfContent: number = this.displayContent.length;
  location: number = 0;
  constructor(public dialog: MatDialog,private storeService: TestService){
    setInterval( ()=>{
      if(this.location == this.lenOfContent){
        this.displayHeader='#';
        this.location = 0;
      }else{
        this.displayHeader += this.displayContent.charAt(this.location);
        this.location += 1;
      }
    }, 200);
  }
  clearData(){
    this.storeService.clearData();
  }
  isLoggedIn(){
    if(this.storeService.checkIfLoggedIn() != null){
      return true;
    }else{
      return false;
    }
  }

  viewMyProfile(){
    const dialogRef =this.dialog.open(ProfileComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
  
}
