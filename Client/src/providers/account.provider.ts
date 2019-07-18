import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Utente } from '../models/utente.model';
import {URL_BASE, URL} from '../constants';
import {UtentePersistanceInterface} from '../interfaces/utentepersistance.interface';
import { UtentePersistanceProvider } from '../providers/utente-persistance.provider';
import { Http, Response} from '@angular/http';
import { ResponseServer} from '../types';

@Injectable()
export class AccountProvider{
    

    private _utente: Utente = null;
    private _sUtentePersistance: UtentePersistanceInterface;
    constructor(
        private _http: Http,
        sUtentePers: UtentePersistanceProvider
    ) {
        console.log('Hello Account Provider');
        
        this._sUtentePersistance = sUtentePers;
    }
    
    initialize(): Promise<any> {
        return new Promise(resolve => {
            this._sUtentePersistance.get()
                .then(utente => {
                    this._utente = utente;
                    resolve();
                })
                .catch(() => resolve());
        });
    }
    
    getUtente(): Utente {
        return this._utente;
    }

    isLogged(): boolean {
        return this._utente !== null;
    }

    login(username: string, password: string): Promise<Utente> {
        return new Promise((resolve, reject) => {
            this._http.post(URL.LOGIN, {username, password})
                .toPromise()
                .then((res: Response) => {
                        const json = res.json() as ResponseServer; 
                        console.log (json.data);
                    if (json.result == true) {
                        var utente = new Utente(json.data);
                        this._utente = utente;
                        console.log(this._utente);
                        this._sUtentePersistance.save(this._utente);
                        resolve(utente);
                    } else {
                        reject(res);
                    }
                })
                .catch((err: Response) => reject(`Errore status: ${err.status}`));
        });
    }

    register(utenteNuovo: Utente): Promise<Utente>{
        return new Promise((resolve, reject) =>{
            this._http.post(URL.REGISTRAZIONE, utenteNuovo)
                .toPromise()
                .then((res: Response) => {
                    const json = res.json() as ResponseServer; 
                    console.log (json.data);
                    if (json.result == true) {
                        var utente = new Utente(json.data);
                        this._utente = utente;
                        console.log(this._utente);
                        this._sUtentePersistance.save(this._utente);
                        resolve(utente);
                    } else {
                        reject(res);
                    }
                })
            .catch((err: Response) => {reject(err)});
        })
    }

    recuperaPassword(email: string): Promise<any> {
        return new Promise((resolve, reject) => {
            this._http.post(URL.RECUPERO + email, "").toPromise().then(() => {
                resolve();
            }).catch(() => reject());
        });
    }

    logout(): Promise<any> {
        return new Promise((resolve, reject) => {
        
        console.log(this._utente);
        
        //this._http.get(URL.LOGOUT + '/' + this._utente.token, "").toPromise()
        this._http.get(URL.LOGOUT + '/' + '3694964129244090425', "").toPromise()
        .then(() => {
        
        this._utente = null;
        this._sUtentePersistance.remove();
        resolve();
        
        }).catch((err: Response) => {console.log(err); reject(`Errore status: ${err.status}`)});
        
        
        });
        }
}