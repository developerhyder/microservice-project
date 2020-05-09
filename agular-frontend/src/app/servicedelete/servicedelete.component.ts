import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-servicedelete',
  templateUrl: './servicedelete.component.html',
  styleUrls: ['./servicedelete.component.css']
})
export class ServicedeleteComponent implements OnInit {
  response: any;
  constructor(private httpRef:HttpClient) { }

  ngOnInit(): void {
  }

  delete(serviceId){
      const options={responseType:'text' as 'text'};
      let obs=this.httpRef.delete("http://localhost:5003//service/delete/"+serviceId.viewModel,options);
      obs.subscribe((response)=>{
        this.response=response;
        console.log(response);
      })
  }

}
