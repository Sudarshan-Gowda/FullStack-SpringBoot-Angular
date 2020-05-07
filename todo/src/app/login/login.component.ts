import { BasicAuthserviceService } from './../service/basic-authservice.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: 'admin';
  password: 'password';
  errorMessage = 'Invalid Credentials!';
  invalidLogin = false;

  constructor(private router: Router, private basicAuthService: BasicAuthserviceService) { }

  ngOnInit(): void {
  }

  jwtAuthLogin() {
    console.log('handle login');
    this.basicAuthService.executeJWTAuthService(this.username, this.password).subscribe(
      data => {
        console.log('data' + data);
        this.router.navigate(['welcome', this.username]);
        this.invalidLogin = false;
      },
      error => {
        console.log('error' + error);
        this.invalidLogin = true;
      }
    );
  }


}
