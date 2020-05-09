import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-serviceshow',
  templateUrl: './serviceshow.component.html',
  styleUrls: ['./serviceshow.component.css']
})
export class ServiceshowComponent implements OnInit {

  responseBody:any;
  constructor(private httpRef:HttpClient) {

   }

  ngOnInit(): void {
    let obs=this.httpRef.get("http://localhost:5003//service/all");
    obs.subscribe((responseBody)=>{
      this.responseBody=responseBody;
      console.log(responseBody);
    });
  }

}
