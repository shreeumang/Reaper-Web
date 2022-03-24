import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, Input, AfterViewInit, ViewChild } from '@angular/core';
import {AddComponent} from '../add/add.component';

@Component({
  selector: 'buttons',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css'],
  providers: [AddComponent]
})
export class ButtonComponent implements AfterViewInit {

  @ViewChild(AddComponent) child;

  @Input() listdata;



  constructor() {

  }

  ngAfterViewInit() {
  }

  public onOpenModal(message: Message, mode: string){
    this.child.onOpenModal(message, mode);
  }

}
