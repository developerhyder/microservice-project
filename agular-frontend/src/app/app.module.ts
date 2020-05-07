import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SlideshowComponent } from './slideshow/slideshow.component';
import { FormsModule } from '@angular/forms';

import { WebStorageModule } from "ngx-web-storage";
import { SignInComponent } from './sign-in/sign-in.component';
import { AvailableSerComponent } from './available-ser/available-ser.component';

@NgModule({
  declarations: [
    AppComponent,
    SlideshowComponent,
    SignInComponent,
    AvailableSerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    WebStorageModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
