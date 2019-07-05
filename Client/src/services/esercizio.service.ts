import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { URL } from '../constants';
import { Esercizio } from '../models/esercizio.model';

@Injectable()

export class EsercizioService{
    constructor (private http: HttpClient){}

    esercizi(livello: any, zona:any): Observable<Array<Esercizio>>{
        console.log("Ciao");
        return this.http.get<Array<Esercizio>>(URL.ESERCIZI +'/livello' + '/' + livello + '/' + zona); //Richiama sul server UrlEsercizi e prende i dati dal database e mi ridà un array di esercizi
    
    }

    allEsercizi(): Observable<Array<Esercizio>>{
        console.log("Ciao");
        return this.http.get<Array<Esercizio>>(URL.ESERCIZI); //Richiama sul server UrlEsercizi e prende i dati dal database e mi ridà un array di esercizi
    
    }

    }