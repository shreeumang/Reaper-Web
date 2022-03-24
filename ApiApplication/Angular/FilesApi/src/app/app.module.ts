import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FileListComponent } from './file-list/file-list.component';
import { FilesServiceService } from './files-service.service';
// import { FileFormComponent } from '';

@NgModule({
  declarations: [
    AppComponent,
    FileListComponent
    // FileFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    // FormsModule
  ],
  providers: [FilesServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
