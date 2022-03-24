import { Component, OnInit } from '@angular/core';
import { ListOfFiles } from '../files';
import { FilesServiceService } from '../files-service.service';

@Component({
  selector: 'app-file-list',
  templateUrl: './file-list.component.html',
  styleUrls: ['./file-list.component.css']
})
export class FileListComponent implements OnInit {

  files: ListOfFiles[] = [];

  constructor(private fileService: FilesServiceService) {
  }

  ngOnInit() {
    this.fileService.findAll().subscribe((data: ListOfFiles[]) => {
      this.files = data;
    });
  }

}
