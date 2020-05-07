import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { BasicAuthserviceService } from './basic-authservice.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private router: Router, private basicAuthService: BasicAuthserviceService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.basicAuthService.isUserLoggedIn()) {
      return true;
    }

    this.router.navigate(['login']);
    return false;

  }


}
