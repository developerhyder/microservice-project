import { Component, OnInit, Input } from '@angular/core';
import{HttpClient} from '@angular/common/http'
@Component({
  selector: 'app-serviceadd',
  templateUrl: './serviceadd.component.html',
  styleUrls: ['./serviceadd.component.css']
})
export class ServiceaddComponent implements OnInit {
  // serviceName:string="";
  // description:string="";
  // cost:number=null;
    post:any;
    responseBody:any;

  constructor(private httpRef:HttpClient) { }

  ngOnInit(): void {
  }
  
  submitData(serviceCost,serviceDescription,servicename){
   this.post={
      cost:serviceCost.viewModel,
      description:serviceDescription.viewModel,
      name:servicename.viewModel
   };
   const options={responseType:'text' as 'text'};

   //console.log(this.post);
    let obs=this.httpRef.post("http://localhost:5003/service/add",this.post,options);
    obs.subscribe(response=>{
      this.responseBody=response;
      console.log(this.responseBody);
    });

  }

}
