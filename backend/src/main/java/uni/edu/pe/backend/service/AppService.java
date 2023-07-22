package uni.edu.pe.backend.service;

import uni.edu.pe.backend.dto.Compra;
import uni.edu.pe.backend.dto.CompraClientes;
import uni.edu.pe.backend.dto.Cupon;

import java.util.List;

public interface AppService {
    List<CompraClientes> reporteCompraClientes();
    Cupon insertarCupon(Cupon cupon);
    Compra actualizarCompra(Compra compra);
}
