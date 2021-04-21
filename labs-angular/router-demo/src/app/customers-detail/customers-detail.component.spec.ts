import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersDetailComponent } from './customers-detail.component';

describe('CustomersDetailComponent', () => {
  let component: CustomersDetailComponent;
  let fixture: ComponentFixture<CustomersDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomersDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
