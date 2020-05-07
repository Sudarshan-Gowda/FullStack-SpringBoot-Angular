import { BasicAuthserviceService } from './../basic-authservice.service';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpEvent, HttpRequest } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor {

  constructor(private basicAuthService: BasicAuthserviceService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {

    const username = this.basicAuthService.getAuthenticatedUser();
    const basicAuthToken =  this.basicAuthService.getAuthenticatedToken();

    if (basicAuthToken && username){
      request = request.clone({
        setHeaders : {
          Authorization : basicAuthToken
        }
      });
    }
    return next.handle(request);
  }

}
