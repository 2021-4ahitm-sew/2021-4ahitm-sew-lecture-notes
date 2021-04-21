import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>Welcome</h1>
    <router-outlet></router-outlet>
    <p>Footer, (c) by ...</p>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'router-demo';

  public tasks = [
    { name: 'Customer One', id: 1},
    { name: 'Customer Two', id: 2},
    { name: 'Customer Three', id: 3},
  ];

}
