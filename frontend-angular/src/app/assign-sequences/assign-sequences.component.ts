import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http' ;

@Component({
  selector: 'app-assign-sequences',
  templateUrl: './assign-sequences.component.html',
  styleUrls: ['./assign-sequences.component.css']
})

export class AssignSequencesComponent {
   assignSequences: Object = [];
   constructor (http: HttpClient) {
                http.get<Object[]>('http://localhost:8080/assign_sequences').subscribe( sequences => this.assignSequences = sequences);
   }
}

/*export class AssignSequencesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

} */
