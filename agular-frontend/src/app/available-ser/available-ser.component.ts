import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TestService } from '../test.service';
import {MatSnackBar} from '@angular/material/snack-bar';


@Component({
  selector: 'app-available-ser',
  templateUrl: './available-ser.component.html',
  styleUrls: ['./available-ser.component.css']
})
export class AvailableSerComponent implements OnInit {
  name : string = "";
  service_id: string ="";
  show = 4;

  responseBack : any;
  response: any;

  isOn:boolean=true;
  isFull:boolean=true;

  //public snackbar: MatSnackBar,
  constructor( private _snackBar: MatSnackBar, private test:TestService, private httpRef : HttpClient) {
    this.fetchServices();
   }


  ngOnInit() {

  }

  showAlertNotification(){
    
    this._snackBar.open("please sign in or sign up","ok", {
      duration:3000,
    });
  }
  processValues(val1, val2, val3){
    console.log(val1+"{{{"+val2+"}}}"+val3);
    //val3->customer id val2->cost val1->service id
    location.replace("http://localhost:4200/pay/"+val3+"/"+val1+"/"+val2);
  }
  fetchServices(){
    this.isOn=!this.isOn;
   let obs = this.httpRef.get("http://localhost:5003/service/all" + this.name);
    obs.subscribe((responseBack) => {
    this.responseBack = responseBack;
    console.log(responseBack)
    });
}
getCustomerId(){
  return this.test.getCustomerId();
}
fetchFull(){
  this.isFull=!this.isFull;
 let obs = this.httpRef.get("http://localhost:5003/service/find/" + this.service_id);
  obs.subscribe((response) => {
  this.response = response;
  });
}

}
