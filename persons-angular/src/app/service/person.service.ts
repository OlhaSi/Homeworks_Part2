import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {Person} from '../model/person';
import {PersonsComponent} from '../persons/persons.component';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private readonly PERSONS_URI = '/api/persons';

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Person[]> {
    return this.httpClient.get<Person[]>(this.PERSONS_URI);
  }

  add(person: Person): Observable<Person> {
    return this.httpClient.post<Person>(this.PERSONS_URI, person);
  }
  //
  // edit(person: Person): Observable<void> {
  //
  // }
  //
  remove(person: Person): Observable<Person> {
    return this.httpClient.delete<Person>(`${this.PERSONS_URI}/${person.id}`);
  }
  //
  // get(id: number): Observable<Person> {
  //
  // }
}
