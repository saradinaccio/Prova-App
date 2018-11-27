import {HttpClient, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { URL } from '../constants';
import { schedaPersonale } from '../models/schedaPersonale.model';


@Injectable()

export class SchedaPersonaleService{
  constructor (private http: HttpClient){}

  schedePersonali(): Observable<Array<schedaPersonale>>{
    console.log("Ciao");
    return this.http.get<Array<schedaPersonale>>(URL.SCHEDEPERSONALI); //Richiama sul server UrlSchedePersonali e prende i dati dal database

  }

  crea(SchedaPersonale : schedaPersonale): Observable<boolean>{
    console.log("LOG.CREA_SCHEDA: " + URL.SCHEDEPERSONALI);
    return this.http.post<boolean>(URL.SCHEDEPERSONALI, SchedaPersonale, {observe: 'response'})
      .map((resp: HttpResponse<boolean>) => {
      console.log("resp.body.valueOf():" + resp.body.valueOf());

      return resp.body;

    });

  }


}
