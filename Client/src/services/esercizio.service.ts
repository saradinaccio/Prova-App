import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { URL } from '../constants';
import { Esercizio } from '../models/esercizio.model';
import { AccountProvider } from '../providers/account.provider';
import { ResponseServer } from '../types';
import { Http, Response} from '@angular/http';


@Injectable()

export class EsercizioService{
    constructor (private http: Http,  private _sAccount: AccountProvider){}
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
            this.http.get(URL.ESERCIZI + '/' + this._sAccount.getUtente().token)
                .toPromise()
                .then((res: Response) => {
                    const json = res.json() as ResponseServer; 
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
            this.http.get(URL.ESERCIZI + '/' + this._sAccount.getUtente().token +'/livello' + '/' + livello + '/' + zona)
                .toPromise()
                .then((res: Response) => {
                    const json = res.json() as ResponseServer; 
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