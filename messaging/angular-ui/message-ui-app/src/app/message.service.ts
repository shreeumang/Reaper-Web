import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Message } from './message';
import { environment } from 'environments/environment';


@Injectable()
export class MessageService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: Http) {
  }

  public getMessages() {
    return this.http.get(`${this.apiServerUrl}/message/all`);

    // return this.http.request(`${this.apiServerUrl}/message/all`)
    // .subscribe(response => console.log(response.text()))
  }


  public addMessage(message: Message): Observable<Response> {
    return this.http.post(`${this.apiServerUrl}/message/add`, message);
  }

  public updateMessage(message: Message): Observable<Response> {
    return this.http.put(`${this.apiServerUrl}/message/update`, message);
  }
  public deleteMessage(messageId:number): Observable<Response> {
    return this.http.delete(`${this.apiServerUrl}/message/delete/${messageId}`);
  }

}
