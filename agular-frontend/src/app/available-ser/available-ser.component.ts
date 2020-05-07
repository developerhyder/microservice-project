import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-available-ser',
  templateUrl: './available-ser.component.html',
  styleUrls: ['./available-ser.component.css']
})
export class AvailableSerComponent implements OnInit {
  name : string = "";
  service_id: string ="";

  responseBack : any;
  response: any;

  isOn:boolean=true;
  isFull:boolean=true;

  constructor(private httpRef : HttpClient) {
    this.fetchServices();
   }

  ngOnInit() {

  }
  fetchServices(){
    this.isOn=!this.isOn;
   let obs = this.httpRef.get("http://localhost:5003/service/all" + this.name);
    obs.subscribe((responseBack) => {
    this.responseBack = responseBack;
    
    });
} 
fetchFull(){
  this.isFull=!this.isFull;
 let obs = this.httpRef.get("http://localhost:5003/service/find/" + this.service_id);
  obs.subscribe((response) => {
  this.response = response;
 
  
  });
}
}
