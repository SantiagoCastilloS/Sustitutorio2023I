package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cupon {
    private int idCupon;
    private String codigo;
    private double porcentajeDescuento;
    private String fechaVencimiento;
    private String horaVencimiento;
    private int idProducto;
}
