import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../ApiService";
import {CompraClientes} from "../../interfaces";

@Component({
  selector: 'app-reporte-compra-clientes',
  templateUrl: './reporte-compra-clientes.component.html',
  styleUrls: ['./reporte-compra-clientes.component.scss']
})
export class ReporteCompraClientesComponent implements OnInit {
  lista: CompraClientes[] = [];
  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.api.reporteCompraClientes().subscribe(data=>{
      this.lista = data.compraClientes;
    })
  }

}
