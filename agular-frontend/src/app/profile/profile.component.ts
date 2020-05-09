import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  customer_id : string = "1";

  response:any;

  isOn:boolean=true;

  constructor(
    private http:HttpClient,
    public dialogRef: MatDialogRef<ProfileComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.fetchTransactions();
     }

  onNoClick(): void {
    this.dialogRef.close();
  }
  
  ngOnInit(): void {
  }
  fetchTransactions(){
    this.isOn=!this.isOn;
   let obs = this.http.get("http://localhost:5000/viewProfile/" + this.customer_id);
    obs.subscribe((response) => {
    this.response = response;
    console.log(this.response);
    
    });
  }
}
