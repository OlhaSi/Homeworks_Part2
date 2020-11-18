import {Component, OnInit, Output} from '@angular/core';
import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {EventEmitter} from '@angular/core';
import {EventService} from '../../service/event.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {

  @Output()
  personCreated = new EventEmitter<Person>();

  person: Person = {};

  isEdit = false;

  constructor(private personService: PersonService, private eventService: EventService) {
  }

  ngOnInit(): void {
    this.eventService
      .subscribeOnPersonToEdit(this.onPersonToEdit);
  }

  private onPersonToEdit = personToEdit => {
    this.person = Object.assign({}, personToEdit);
    this.isEdit = true;
  }

  onAdd(): void {
    this.personService.add(this.person)
      .subscribe(newPerson => {
        this.personCreated.emit(newPerson);
        this.person = {};
      });
  }

  onEdit(): void {
    this.personService.edit(this.person);
  }

  onCancel(): void {
    this.isEdit = false;
    this.person = {};
  }

}
