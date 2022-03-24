import { Component, ViewChild, Input, AfterViewInit } from '@angular/core';
import { Message } from 'app/message';
import {AddComponent} from '../add/add.component';

@Component({
  selector: 'tables',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
  providers:[AddComponent]
})
export class TableComponent implements AfterViewInit {

  @Input() listdata;
  @ViewChild(AddComponent) child;

  constructor(
    private add: AddComponent
  ) { }

  ngAfterViewInit() {
  }

  public onOpenModal(message: Message, mode: string){
    this.child.onOpenModal(message, mode);
  }

}
