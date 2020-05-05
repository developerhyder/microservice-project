import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  isSignIn: boolean = false;
  isSignUp: boolean = false;
  
  constructor() {
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
    if(val1 == null ||  val2 == null){
      console.log("looks like you have forgotten to fill the fields");
    }else{
      console.log("got the response");
    }
    if (val1.invalid || val2.invalid){
      console.log("validation failed");
    }else{
      console.log("validation successfull");
    }
  }
}