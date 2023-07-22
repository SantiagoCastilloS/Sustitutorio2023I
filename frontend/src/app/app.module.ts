import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ReporteCompraClientesComponent } from './reporte-compra-clientes/reporte-compra-clientes.component';
import { InsertarCuponComponent } from './insertar-cupon/insertar-cupon.component';
import { ActualizarCompraComponent } from './actualizar-compra/actualizar-compra.component';

@NgModule({
  declarations: [
    AppComponent,
    ReporteCompraClientesComponent,
    InsertarCuponComponent,
    ActualizarCompraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
