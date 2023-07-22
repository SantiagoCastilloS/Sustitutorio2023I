export interface CompraClientes {
  dni: string;
  nombreCompleto: string;
  precioFinal: number;
  cantidad: number;
  fechaCompra: string;
  formaPago: string;
  estado: string;
  codigo: string;
  porcentajeDescuento: number;
  fechaVencimiento: string;
  precioVenta: number;
  ruc: string;
  razonSocial: string;
}
export interface RespuestaCompraClientes {
  compraClientes: CompraClientes[];
}

export interface Cupon{
  idCupon: number;
  codigo: string;
  porcentajeDescuento: number;
  fechaVencimiento: string;
  horaVencimiento: string;
  idProducto: number;
}

export interface Compra {
  estado: string ;
  formaPago: string ;
  codigo: string ;
  dni: string ;

}
