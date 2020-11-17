import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {PersonsComponent} from './persons/persons.component';
import {AppRoutingModule} from './app-routing.module';
import { PersonItemComponent } from './persons/person-item/person-item.component';
import { HttpClientModule} from '@angular/common/http';
import { PersonFormComponent } from './persons/person-form/person-form.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PersonsComponent,
    PersonItemComponent,
    PersonFormComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
