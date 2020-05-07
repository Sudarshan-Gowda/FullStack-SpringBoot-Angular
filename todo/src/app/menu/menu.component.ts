import { BasicAuthserviceService } from './../service/basic-authservice.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public authserviceService: BasicAuthserviceService) {
  }

  ngOnInit(): void {
  }

}
