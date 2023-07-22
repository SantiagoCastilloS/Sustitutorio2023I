package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraClientes {
    private String dni;
    private String nombreCompleto;
    private double precioFinal;
    private int cantidad;
    private String fechaCompra;
    private String formaPago;
    private String estado;
    private String codigo;
    private double porcentajeDescuento;
    private String fechaVencimiento;
    private double precioVenta;
    private String ruc;
    private String razonSocial;
}
