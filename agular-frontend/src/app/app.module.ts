//import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SlideshowComponent } from './slideshow/slideshow.component';
import { FormsModule } from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import { WebStorageModule } from "ngx-web-storage";
import { SignInComponent } from './sign-in/sign-in.component';
import { AvailableSerComponent } from './available-ser/available-ser.component';
import { ServiceaddComponent } from './serviceadd/serviceadd.component';
import { ServiceAdminComponent } from './service-admin/service-admin.component';
import { ServicedeleteComponent } from './servicedelete/servicedelete.component';
import { ServiceupdateComponent } from './serviceupdate/serviceupdate.component';
import { ServiceshowComponent } from './serviceshow/serviceshow.component';
import { HomeComponent } from './home/home.component';
import { PayComponent } from './pay/pay.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { ProfileComponent } from './profile/profile.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {
  MatButtonModule,
} from '@angular/material/button';
import{
  MatCommonModule,
 } from '@angular/material/core';
@NgModule({
  declarations: [
    AppComponent,
    SlideshowComponent,
    SignInComponent,
    AvailableSerComponent,
    ServiceaddComponent,
    ServiceAdminComponent,
    ServicedeleteComponent,
    ServiceupdateComponent,
    ServiceshowComponent,
    HomeComponent,
    PayComponent,
    ProfileComponent
  ],
  imports: [
    //BrowserModule,
    AppRoutingModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    WebStorageModule.forRoot(),
    HttpClientModule,
    FormsModule,
    MatSnackBarModule,
    MatButtonModule,
    MatCommonModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
