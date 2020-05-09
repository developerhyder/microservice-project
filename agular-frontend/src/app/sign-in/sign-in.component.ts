import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  isSignIn: boolean = false;
  isSignUp: boolean = false;
  
  showAlertinLogin: boolean = false;
  messageLogin:string;

  showAlert: boolean=false;
  message: string;
  post:any;
  constructor(private _snackBar:MatSnackBar,private httpRef: HttpClient, private storeService: TestService) {
  }

  ngOnInit(): void {
  }
  
  signInButton(){
    this.isSignIn=true;
    this.isSignUp=false;
  }
  signUpButton(){
    this.isSignUp=true;
    this.isSignIn=false;
  }
  hide(){
    this.isSignIn=false;
    this.isSignUp=false;
  }
  loginValidate(val1, val2){
    this.showAlertinLogin=false;
    if(val1 == null ||  val2 == null){
      console.log("looks like you have forgotten to fill the fields");
    }else{
      console.log("got the response");
    }
    if (val1.invalid || val2.invalid){
      console.log("validation failed");
    }else{
      console.log("validation successfull");
      const options = {responseType: 'text' as 'text'};
      let obs = this.httpRef.get("http://localhost:5001/customer/signin/"+val2.viewModel+"/"+val1.viewModel, options);
      
      obs.subscribe((responseBack)=>
        this.processResponse(responseBack, val1, val2)
      );      
    }
    console.log(val1.viewModel +"!!!"+ val2.viewModel);
  }
  processResponse(responseBack: string, val1, val2){
    if(responseBack == "login successfull"){
      console.log("validated");
      this.addCustomerId(val2.value);
      this.storeService.save(val2.value);
      this._snackBar.open("login successfull", "ok", {
        duration:3000,
      });
    }else{
      console.log("wrong credentials");
      this.showAlertinLogin=true;
      this.messageLogin="looks like you have entered wrong credentials";
    }
  }
  addCustomerId(val){
    const options = {responseType: 'text' as 'text'};
      let obs = this.httpRef.get("http://localhost:5001/customer/getByEmail/"+val, options);
      
      obs.subscribe((responseBack)=>
        console.log(this.storeService.saveCustomerId(responseBack)+"|000|"+ responseBack)
      );
  }
  checkloggedIn(){
    if(this.storeService.checkIfLoggedIn() == null){
      return true;
    }else{
      return false;
    }
  }

  signinValidate(val1, val2, val3){
    //actually this is is supposed to be signup validate
    this.showAlert=false;
    if(val1 == null ||  val2 == null){
      console.log("looks like you have forgotten to fill the fields");
    }else{
      console.log("got the response");
    }
    if (val1.invalid || val2.invalid){
      console.log("validation failed");
    }else{
      console.log("validation was successfull");
      this.post={
        email:val1.viewModel,
        name:val2.viewModel,
        password:val3.viewModel
      }
      const options = {responseType: 'text' as 'text'};
      let obs = this.httpRef.post("http://localhost:5001/customer/signup", this.post, options)
      
      obs.subscribe((responseBack)=>
        this.processResponseFromSignup(responseBack, val1)
      );
      
    }
    

    console.log(val1.viewModel+"{{{{}}}}"+val2.viewModel+"{{{{{{{{}}}}}}}}"+ val3.viewModel);
  }

  processResponseFromSignup(responseBack, val1){
    if(responseBack.indexOf("otp was sent to") != -1){
      console.log(responseBack);
      this.isSignUp=false;
      this._snackBar.open(responseBack, "ok",
      {
        duration:3000,
      });
    }else{
      console.log("something terrible happened");
      this.showAlert=true;
      this.message="could not login ! "+responseBack;
    }
  }
}
