import { Component, OnInit } from '@angular/core';

import { Client } from '../client';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;

  constructor() { 
    this.client = new Client();
  }

  ngOnInit(): void {
  }

  click() {
    console.log(this.client);
    
  }

}
