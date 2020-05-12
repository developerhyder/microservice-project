import { Component, AfterViewChecked } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
declare let paypal: any;

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements AfterViewChecked {
  addScript: boolean = false;
  paypalLoad: boolean = true;
  response:any;
  profile:Object;
  customerId:number;
  finalAmount: number ;
  serviceId:number;
  beforePayment: boolean=true;
  constructor(private httpRef: HttpClient,private route: ActivatedRoute){
    this.route.params.subscribe(params => this.processParams(params));
  }
 
  processParams(params){
    // '+' is used to convert a string to a number

    this.finalAmount = +params.cost;
    this.customerId = +params.id;
    this.serviceId= +params.serviceid;
    console.log("amount: "+this.finalAmount+" customerId: "+this.customerId+" service id: "+this.serviceId);
  }
  paypalConfig = {
    env: 'sandbox',
    client: {
      sandbox: '',//paste the client id here
      //production: '<your-production-key here>'
    },
    commit: true,
    payment: (data, actions) => {
      return actions.payment.create({
        payment: {
          transactions: [
            { amount: { total: this.finalAmount, currency: 'INR' } }
          ]
        }
      });
    },
    onAuthorize: (data, actions) => {
      return actions.payment.execute().then((payment) => {
        this.response=payment;
        console.log(payment);
        this.processPayment(payment);
      })
    }
  };
 
  processPayment(payment){
    console.log(payment.state+"||||"+payment.id);
    if(payment.state.indexOf("approved")!= -1){
      console.log("success");
      var address=""+payment.payer.payer_info.shipping_address.city+" Line: "+payment.payer.payer_info.shipping_address.line1+" pin: "+ payment.payer.payer_info.shipping_address.postal_code;
      this.addTransaction(payment.id, address);
      console.log("address"+ payment.payer.payer_info.shipping_address.city+payment.payer.payer_info.shipping_address.line1);

    }else{
      console.log("failed");
    }
  }
  addTransaction(val, address){
    this.beforePayment = false;
    const options = {responseType: 'text' as 'text'};
      let obs = this.httpRef.get("http://localhost:5000/buy/"+val+"/"+this.serviceId+"/"+this.customerId+"/"+address,options);
      obs.subscribe((responseBack)=>
        this.processBuy(responseBack)
      );
  }
  processBuy(val){
    
    if(val.indexOf("Transaction added") != -1){
      location.replace("http://localhost:4200");
    }else{
      
    }
  }
  ngAfterViewChecked(): void {
    if (!this.addScript) {
      this.addPaypalScript().then(() => {
        paypal.Button.render(this.paypalConfig, '#paypal-checkout-btn');
        this.paypalLoad = false;
      })
    }
  }
  
  addPaypalScript() {
    this.addScript = true;
    return new Promise((resolve, reject) => {
      let scripttagElement = document.createElement('script');    
      scripttagElement.src = 'https://www.paypalobjects.com/api/checkout.js';
      scripttagElement.onload = resolve;
      document.body.appendChild(scripttagElement);
    })
  }

}
