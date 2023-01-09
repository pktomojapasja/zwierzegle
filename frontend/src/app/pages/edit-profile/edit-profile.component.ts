import { Component } from '@angular/core';
import { RegistrationRequest } from 'src/app/model/registration-request.model';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent {

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
  visible = false;
  
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.authService.register(this.form);
  }


}
