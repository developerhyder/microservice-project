import { Injectable } from '@angular/core';
import { WebStorageService } from 'ngx-web-storage';
@Injectable({
  providedIn: 'root'
})
export class TestService {

  emailIdToken:string="emailToken";
  customerIdToken:string="customerId";
  constructor(private storage: WebStorageService) { }

  save(val){
   this.storage.local.set(this.emailIdToken, val);
  }
  checkIfLoggedIn(){
    return this.storage.local.get(this.emailIdToken);
  }
  saveCustomerId(val){
    var k=  +val;
    console.log("customerid Test:" + k);
    return this.storage.local.set(this.customerIdToken, k);
  }
  clearData(){
    this.storage.local.clear();
    console.log(this.getCustomerId());
  }

  getCustomerId(){
    return this.storage.local.get(this.customerIdToken);
  }
}
