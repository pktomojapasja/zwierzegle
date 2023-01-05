export interface RegistrationRequest {

    registration: {
        email : string,
        password : string,
        type : string
    }

    contact: {
        name : string,
        organizationName : string,
        phoneNumber : string,
        email : string,
        street : string,
        buildingNumber : string,
        flatNumber : string,
        city : string,
        zipCode : string
    }
    
}
