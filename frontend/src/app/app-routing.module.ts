import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReporteCompraClientesComponent} from "./reporte-compra-clientes/reporte-compra-clientes.component";
import {InsertarCuponComponent} from "./insertar-cupon/insertar-cupon.component";
import {ActualizarCompraComponent} from "./actualizar-compra/actualizar-compra.component";

const routes: Routes = [
  {path:"", component:ReporteCompraClientesComponent},
  {path:"insertar", component:InsertarCuponComponent},
  {path:"actualizar", component:ActualizarCompraComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
