import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './pages/home/home.component';
import { BlogComponent } from './pages/blog/blog.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';

import { AuthInterceptor } from './helpers/auth.interceptor';
import { LoginComponent } from './pages/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './pages/register/register.component';
import { ContactComponent } from './pages/contact/contact.component';
import { UserRegisterComponent } from './pages/user-register/user-register.component';
import { FoundationRegisterComponent } from './pages/foundation-register/foundation-register.component';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';
import { HowCanYouHelpComponent } from './pages/how-can-you-help/how-can-you-help.component';
import { HowAdoptComponent } from './pages/how-adopt/how-adopt.component';
import { BefriendPetComponent } from './pages/befriend-pet/befriend-pet.component';
import { EditProfileComponent } from './pages/edit-profile/edit-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BlogComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    ContactComponent,
    UserRegisterComponent,
    FoundationRegisterComponent,
    ChangePasswordComponent,
    HowCanYouHelpComponent,
    HowAdoptComponent,
    BefriendPetComponent,
    EditProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthInterceptor],
  bootstrap: [AppComponent]
})
export class AppModule { }
