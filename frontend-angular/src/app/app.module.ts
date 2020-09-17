import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {InputTextModule} from 'primeng/inputtext' ;
import {ButtonModule} from 'primeng/button' ;
import {TableModule} from 'primeng/table' ;
import {TooltipModule} from 'primeng/tooltip' ;
import { AppComponent } from './app.component' ;
import { Component, OnInit } from '@angular/core' ;
import { HttpClient } from '@angular/common/http' ;
import { HttpClientModule } from '@angular/common/http' ;
import { AppRoutingModule } from './app-routing.module';
import { AssignSequencesComponent } from './assign-sequences/assign-sequences.component';

@NgModule({
  declarations: [AppComponent, AssignSequencesComponent],
  imports: [BrowserModule, InputTextModule, ButtonModule, TableModule, TooltipModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent]
})

/*export class AssignSequencesComponent {
   assignSequences: Object = [];
   constructor (http: HttpClient) {
                http.get<Object[]>('http://localhost:8080/assign_sequences').subscribe( sequences => this.assignSequences = sequences);
   }
} */

export class AppModule { }
