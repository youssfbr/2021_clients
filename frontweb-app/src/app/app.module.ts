import { SidebarComponent } from './template/sidebar/sidebar.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { TemplateModule } from './template/template.module';
import { AppComponent } from './app.component';

import { ClientsModule } from './clients/clients.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,    
    ClientsModule,
    TemplateModule    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
