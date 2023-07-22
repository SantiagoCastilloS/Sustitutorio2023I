import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../ApiService";
import {Compra} from "../../interfaces";

@Component({
  selector: 'app-actualizar-compra',
  templateUrl: './actualizar-compra.component.html',
  styleUrls: ['./actualizar-compra.component.scss']
})
export class ActualizarCompraComponent implements OnInit {
  mensaje: string = "";
  compra: Compra = {} as Compra;
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  actualizar() {
    this.api.actualizarCompra(this.compra).subscribe(retorno=>{
      this.mensaje = "La compra con codigo de cupon " + retorno.codigo + " y con dni de cliente " + retorno.dni
      + " fue actualizada correctamente";
      console.log(this.mensaje);
    })
  }
}
