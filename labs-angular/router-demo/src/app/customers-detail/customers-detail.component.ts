import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customers-detail',
  templateUrl: './customers-detail.component.html',
  styleUrls: ['./customers-detail.component.css']
})
export class CustomersDetailComponent implements OnInit {

  public id = '';

  constructor(private route: ActivatedRoute) {
    route.paramMap.subscribe(
      map => this.id = map.get('id')
    );
  }

  ngOnInit(): void {
  }

}
