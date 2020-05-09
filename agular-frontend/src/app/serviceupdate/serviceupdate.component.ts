import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-serviceupdate',
  templateUrl: './serviceupdate.component.html',
  styleUrls: ['./serviceupdate.component.css']
})
export class ServiceupdateComponent implements OnInit {
  response:any;
  post:Object;
  
  constructor(private httpRef:HttpClient) { }

  ngOnInit(): void {
  }

  submitData(id,name,description,cost){
      this.post={
        serviceId:id.viewModel,
        name:name.viewModel,
        description:description.viewModel,
        cost:cost.viewModel
      };
      const options={responseType:'text' as 'text'};

      let obs=this.httpRef.post("http://localhost:5003//service/update",this.post,options);
      obs.subscribe((response)=>{
        this.response=response;
      });

  }

}
