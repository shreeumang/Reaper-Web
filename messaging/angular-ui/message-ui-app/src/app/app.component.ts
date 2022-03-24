import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { MessageService } from './message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  public listdata: Message[];


  constructor(private messageService: MessageService){}

  ngOnInit() {
    this.getMessages();
  }

  public getMessages():void {
    this.messageService.getMessages().subscribe(
      (response: any=[]) => {
        this.listdata = response.json();
      },
      (error: any) => {
        alert(error.message);
      }
    );
  }

}
