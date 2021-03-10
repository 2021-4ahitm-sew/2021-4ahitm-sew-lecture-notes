import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-numeric-input',
  templateUrl: './numeric-input.component.html',
  styleUrls: ['./numeric-input.component.css']
})
export class NumericInputComponent implements OnInit {
 @Input() public value = 0;
 @Output() public resetClicked = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }

  public onResetClicked(): void {
    this.resetClicked.emit();
  }

}
