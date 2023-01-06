import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';
import { BlogComponent } from './pages/blog/blog.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ContactComponent } from './pages/contact/contact.component';
import { UserRegisterComponent } from './pages/user-register/user-register.component';
import { FoundationRegisterComponent } from './pages/foundation-register/foundation-register.component';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';

const routes: Routes = [
  {path:  "", pathMatch:  "full", component: HomeComponent},
  {path: "blog", component: BlogComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "contact", component: ContactComponent},
  {path: "user-register", component: UserRegisterComponent},
  {path: "foundation-register", component: FoundationRegisterComponent},
  {path: "change-password", component: ChangePasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
