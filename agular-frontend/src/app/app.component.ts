import { Component } from '@angular/core';
import { TestService } from './test.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  displayHeader: string='';
  title = 'frontend';
  displayContent: string="Service IT";
  lenOfContent: number = this.displayContent.length;
  location: number = 0;
  constructor(private storeService: TestService){
    setInterval( ()=>{
      if(this.location == this.lenOfContent){
        this.displayHeader='#';
        this.location = 0;
      }else{
        this.displayHeader += this.displayContent.charAt(this.location);
        this.location += 1;
      }
    }, 200);
  }
  clearData(){
    this.storeService.clearData();
  }
  isLoggedIn(){
    if(this.storeService.checkIfLoggedIn() != null){
      return true;
    }else{
      return false;
    }
  }
}
