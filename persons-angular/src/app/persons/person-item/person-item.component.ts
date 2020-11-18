import {Component, Input, OnInit, Output} from '@angular/core';
import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {EventEmitter} from '@angular/core';
import {EventService} from '../../service/event.service';

@Component({
  selector: 'app-person-item',
  templateUrl: './person-item.component.html',
  styleUrls: ['./person-item.component.css']
})
export class PersonItemComponent implements OnInit {

  @Input()
  person: Person = {};

  @Output()
  personToRemove = new EventEmitter<Person>();

  constructor(private personService: PersonService, private eventService: EventService) {
  }

  ngOnInit(): void {
  }

  onDelete(): void {
    this.personService.remove(this.person)
      .subscribe(person => {
        this.personToRemove.emit(person);
      });
  }

  onEdit(person: Person): void {
    this.eventService.addPersonToEdit(this.person);
  }
}
