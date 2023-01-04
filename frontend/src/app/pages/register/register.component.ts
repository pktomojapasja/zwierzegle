import { Component } from '@angular/core';
import { RegistrationRequest } from 'src/app/model/registration-request.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  form : RegistrationRequest = {
    "registration": {
      "email": "",
      "password": "",
      "type": "USER"
    },
    "contact": {
      "name": "",
      "organizationName": "",
      "phoneNumber": "",
      "email": "",
      "street": "",
      "buildingNumber": "",
      "flatNumber": "",
      "city": "",
      "zipCode": ""
    }
  }

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.authService.register(this.form);
  }

}
