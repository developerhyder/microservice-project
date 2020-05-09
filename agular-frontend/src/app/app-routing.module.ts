import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServiceAdminComponent } from './service-admin/service-admin.component';

import { HomeComponent } from './home/home.component';
import { PayComponent } from './pay/pay.component';


const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
  {
    path:'pay/:id/:serviceid/:cost', component:PayComponent
  },
  {
    path:"admin", component:ServiceAdminComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
