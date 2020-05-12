import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
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
  serviceName:string;
  responseBody:any;
  displayContent: string="Service IT";
  lenOfContent: number = this.displayContent.length;
  location: number = 0;
  constructor(private _snackBar:MatSnackBar, private httpRef:HttpClient, public dialog: MatDialog,private storeService: TestService){
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
    console.log("clear data!!")
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

  searchNames(serviceName){ 
    if(serviceName.viewModel==""){

    }
    else{
    this.httpRef.get("http://localhost:5003//service/serviceByName/"+serviceName.viewModel).subscribe((responseBody)=>{
      this.responseBody=responseBody;
      console.log(responseBody);
      
    });
    }
  }

  processValues(val1, val2){
    console.log(val1+"{{{"+val2+"}}}");
    // val2->cost val1->service id
    var val3 = this.getCustomerId();
    if(val3 == null){
      this._snackBar.open("you need to sign in first", "ok",
      {
        duration:3000,
      });
    }else{
      location.replace("http://localhost:4200/pay/"+val3+"/"+val1+"/"+val2);
    }
    
  }
  getCustomerId(){
    return this.storeService.getCustomerId();
  }
}
