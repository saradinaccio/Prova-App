export class Utente { 
    public id: number = -1;
    public nome: string = "";
    public cognome: string = "";
    public email: string = "";
    public password: string = "";
    public altezza: Number = 0;
    public peso: Number = 0;
    public eta: Number = 0;
    public username: String = "";
    public token: String = "";
    constructor (obj ? : any){
        this.set(obj);
    }
    set(obj ? : any){
        if (obj) {
            this.id = (typeof obj.id === "number") ? obj.id : this.id;
            this.nome = obj.nome || this.nome;
            this.cognome = obj.cognome || this.cognome;
            this.email = obj.email || this.email;
            this.password = obj.password || this.password;
            this.peso = (typeof obj.peso === "number") ? obj.peso : this.peso;
            this.eta = (typeof obj.eta === "number") ? obj.eta : this.eta;
            this.altezza = (typeof obj.altezza === "number") ? obj.altezza : this.altezza;
            this.username = obj.username || this.username;
            this.token = obj.token || this.token;
        }
    }
}