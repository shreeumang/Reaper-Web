import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ListOfFiles } from '../app/files';
import { Observable } from 'rxjs';

@Injectable()
export class FilesServiceService {

  private fileUrl: string;

  constructor(private http: HttpClient) {
    this.fileUrl = 'http://localhost:8081/ApiApplication/ListFiles';
  }

  public findAll(): Observable<ListOfFiles[]> {
    return this.http.get<ListOfFiles[]>(this.fileUrl);
  }

}
