
//Models
import {Utente} from '../models/utente.model';

export interface UtentePersistanceInterface {
    
    save(utente: Utente): Promise<any>;
    
    get(): Promise<Utente>;
    
    remove(): Promise<any>;
    
}