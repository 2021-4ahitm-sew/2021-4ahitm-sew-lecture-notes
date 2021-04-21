import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  public customers = [
    { name: 'Customer One', id: 1 },
    { name: 'Customer Two', id: 2 },
    { name: 'Customer Three', id: 3 }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
