import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers/customers.component';
import { CustomersDetailComponent } from './customers-detail/customers-detail.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'customers'},
  {path: 'customers', component: CustomersComponent},
  {path: 'customers/:id', component: CustomersDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
