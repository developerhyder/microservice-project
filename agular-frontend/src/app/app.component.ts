import { Component } from '@angular/core';

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
  constructor(){
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
  
}
