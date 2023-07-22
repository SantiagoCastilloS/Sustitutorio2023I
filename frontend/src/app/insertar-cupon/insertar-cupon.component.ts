import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../ApiService";
import {Cupon} from "../../interfaces";

@Component({
  selector: 'app-insertar-cupon',
  templateUrl: './insertar-cupon.component.html',
  styleUrls: ['./insertar-cupon.component.scss']
})
export class InsertarCuponComponent implements OnInit {
  data: Cupon = {} as Cupon;
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }
  insertar() {
    console.log("METODO INSERTAR CUPON")
    this.api.insertarCupon(this.data).subscribe(data=>{
      console.log("El cupon con id " + data.idCupon + " se registro correctamente")
    })
  }
}
