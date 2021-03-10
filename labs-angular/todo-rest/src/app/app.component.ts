import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface IPerson {
  name: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'todo-rest';
  people: IPerson[] = [];

  constructor(private http: HttpClient) {
  }

  async loadPeople() {
    this.people = await this.http
      .get<IPerson[]>('http://localhost:8080/api/people')
      .toPromise();
  }
}
