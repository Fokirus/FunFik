import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../../constants";
import { RegistrationDto } from "../../models/registration.dto";

@Injectable({ providedIn: 'root' })
export class AuthService{

    constructor(private http:HttpClient){}

    public registration(username: string, email: string, password: string) {
        let registrationDto: RegistrationDto = {
            username: username,
            email: email,
            password: password
        };
        return this.http.post(Constants.URL + "/user/registration", registrationDto);
    }

    public login() {
        
    }
}