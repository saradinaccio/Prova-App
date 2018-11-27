import { HttpClient } from '@angular/common/http';
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


}
