import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { User } from "src/app/models/user";

@Injectable({ providedIn: 'root' })
export class UserService{
    private url: string = "http://localhost:8080/";

    constructor(private http:HttpClient){}

    public getUserById(id: number){
        return this.http.get<User>(this.url + `/user/${id}`);
    }
}