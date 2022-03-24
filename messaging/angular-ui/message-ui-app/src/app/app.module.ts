import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { TableComponent } from './table/table.component';
import { ButtonComponent } from './button/button.component';
import { AddComponent } from './add/add.component';
import { MessageService } from './message.service';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    ButtonComponent,
    AddComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
  ],
  providers: [ButtonComponent,AddComponent,TableComponent,MessageService, AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
