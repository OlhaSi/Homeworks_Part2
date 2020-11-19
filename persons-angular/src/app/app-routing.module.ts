import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PersonsComponent} from './persons/persons.component';
import {PersonDetailsComponent} from './person-details/person-details.component';


const routes: Routes = [
  { path: 'persons', component: PersonsComponent },
  { path: '', redirectTo: '/persons', pathMatch: 'full' },
  { path: 'persons/:id', component: PersonDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
