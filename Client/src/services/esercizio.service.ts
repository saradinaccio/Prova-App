import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { URL } from '../constants';
import { Esercizio } from '../models/esercizio.model';
import { Utente } from '../models/utente.model';
import { ResponseServer } from '../types';
import { Http, Response} from '@angular/http';


@Injectable()

export class EsercizioService{
    constructor (private http: Http){}
/*
    esercizi(livello: any, zona:any): Observable<Array<Esercizio>>{
        console.log("Ciao");
        return this.http.get<Array<Esercizio>>(URL.ESERCIZI +'/livello' + '/' + livello + '/' + zona); //Richiama sul server UrlEsercizi e prende i dati dal database e mi ridà un array di esercizi
    
    }

    allEsercizi(utente : Utente): Observable<Array<Esercizio>>{
        console.log("Ciao");
        return this.http.get<Array<Esercizio>>(URL.ESERCIZI + '/' + '2904899154611209978'); //Richiama sul server UrlEsercizi e prende i dati dal database e mi ridà un array di esercizi
    
    }
*/
    getAllEsercizi(): Promise<Array<Esercizio>>{
        return new Promise((resolve, reject) =>{
            this.http.get(URL.ESERCIZI + '/' + '2904899154611209978')
                .toPromise()
                .then((res: Response) => {
                    const json = res.json() as any as ResponseServer; 
                    console.log (json.data);
                    if (json.result == true) {
                        console.log("dai");
                        console.log(json.data);
                        resolve(json.data);
                    } else {
                        reject(res);
                    }
                })
            .catch((err: Response) => {reject(err)});
        })
    }

    esercizi(livello: any, zona:any): Promise<Array<Esercizio>>{
        return new Promise((resolve, reject) =>{
            this.http.get(URL.ESERCIZI + '/2904899154611209978' +'/livello' + '/' + livello + '/' + zona)
                .toPromise()
                .then((res: Response) => {
                    const json = res.json() as any as ResponseServer; 
                    console.log (json.data);
                    if (json.result == true) {
                        console.log("dai");
                        console.log(json.data);
                        resolve(json.data);
                    } else {
                        reject(res);
                    }
                })
            .catch((err: Response) => {reject(err)});
        })
    }

}