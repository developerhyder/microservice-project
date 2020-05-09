import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-admin',
  templateUrl: './service-admin.component.html',
  styleUrls: ['./service-admin.component.css']
})
export class ServiceAdminComponent implements OnInit {
  add: boolean=true;
  update: boolean=false;
  delete: boolean=false;
  show: boolean=false;
  responseBody:any;
  userName:string="admin";
  password:string="admin123";
  res:boolean=false;

  constructor() { }

  ngOnInit(): void {
  }

  toggleAdd(){  
    this.add=true;
    this.update=false;
    this.delete=false;
    this.show=false;
  }
  toggleUpdate(){
    this.update=true;
    this.add=false;
    this.delete=false;
    this.show=false;
  }
  toggleDelete(){
    this.delete=true;
    this.add=false;
    this.update=false;
    this.show=false;    
  }
  toggleShow(){
    this.show=true;
    this.add=false;
    this.delete=false;
    this.update=false;
  }

  submit(val1,val2){
    console.log(val2.viewModel);
    console.log(val1.viewModel);
    if(this.userName==val1.viewModel && this.password==val2.viewModel){
        
        this.res=true;
        
    }
}
  logout(){
  this.res=false;
}
 
}
