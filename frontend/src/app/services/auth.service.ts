import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { RegistrationRequest } from '../model/registration-request.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(email: string, password: string) {
    return this.http.post('/api/auth/login', { email, password })
      .subscribe((res: any) => {
        localStorage.setItem('token', res.token);
        location.href = "/";
      });
  }

  register(req : RegistrationRequest) {
    return this.http.post('/api/auth/register', req)
      .subscribe((res: any) => {
        localStorage.setItem('token', res.token);
        location.href = "/";
      });
  }

  logout() {
    localStorage.removeItem("token");
    location.reload();
  }

  getToken() {
    return localStorage.getItem('token');
  }

  public isLoggedIn() {
    return this.getToken() !== null
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

}
