package uni.edu.pe.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.backend.dto.Compra;
import uni.edu.pe.backend.dto.CompraClientes;
import uni.edu.pe.backend.dto.Cupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppDaoImp implements AppDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection conexion;
    private void obtenerConexion(){
        try {
            conexion = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion() {
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CompraClientes> reporteCompraClientes() {
        List<CompraClientes> lista = new ArrayList<>();
        String sql = "SELECT\n" +
                "\tcl.dni,\n" +
                "\tcl.nombre_completo,\n" +
                "\tcom.cantidad * (1 - cup.porcentaje_descuento) * p.precio_venta AS precioFinal,\n" +
                "\tcom.cantidad,\n" +
                "\tcom.fecha_compra,\n" +
                "\tcom.forma_pago,\n" +
                "\tcom.estado,\n" +
                "\tcup.codigo,\n" +
                "\tcup.porcentaje_descuento,\n" +
                "\tcup.fecha_vencimiento,\n" +
                "\tp.precio_venta,\n" +
                "\tpr.ruc,\n" +
                "\tpr.razon_social\n" +
                "FROM cliente cl\n" +
                "LEFT JOIN compra com ON (com.id_cliente = cl.id_cliente)\n" +
                "LEFT JOIN cupon cup ON (cup.id_cupon = com.id_cupon)\n" +
                "LEFT JOIN producto p ON (p.id_producto = cup.id_producto)\n" +
                "LEFT JOIN proveedor pr ON (pr.id_proveedor = p.id_proveedor)\n" +
                "WHERE (com.estado = 'A' OR com.estado IS NULL) AND (com.forma_pago = 'C' OR com.forma_pago IS NULL)\n" +
                "ORDER BY cl.dni ASC, precioFinal DESC;";
        try {
            obtenerConexion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                lista.add(extraerCompraClientes(resultado));
            }
            cerrarConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    @Override
    public Cupon insertarCupon(Cupon cupon) {
        String sql = "INSERT INTO cupon VALUES (?,?,?,?,?,?)";
        try {
            obtenerConexion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, cupon.getIdCupon());
            sentencia.setString(2, cupon.getCodigo());
            sentencia.setDouble(3, cupon.getPorcentajeDescuento());
            sentencia.setString(4, cupon.getFechaVencimiento());
            sentencia.setString(5, cupon.getHoraVencimiento());
            sentencia.setInt(6, cupon.getIdProducto());
            sentencia.executeUpdate();
            cerrarConexion();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return cupon;
    }

    @Override
    public Compra actualizarCompra(Compra compra) {
        String sql = "UPDATE compra c SET c.estado = ?, c.forma_pago = ? WHERE c.id_cupon = (SELECT cu.id_cupon FROM cupon cu WHERE cu.codigo = ?) \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAND c.id_cliente = (SELECT cl.id_cliente FROM cliente cl WHERE cl.dni = ?);";
        try {
            obtenerConexion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, compra.getEstado());
            sentencia.setString(2, compra.getFormaPago());
            sentencia.setString(3, compra.getCodigo());
            sentencia.setString(4, compra.getDni());
            sentencia.executeUpdate();
            cerrarConexion();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return compra;
    }

    private CompraClientes extraerCompraClientes(ResultSet resultado) throws SQLException {
        CompraClientes compraClientes = new CompraClientes(
                resultado.getString("dni"),
                resultado.getString("nombre_completo"),
                resultado.getDouble("precioFinal"),
                resultado.getInt("cantidad"),
                resultado.getString("fecha_compra"),
                resultado.getString("forma_pago"),
                resultado.getString("estado"),
                resultado.getString("codigo"),
                resultado.getDouble("porcentaje_descuento"),
                resultado.getString("fecha_vencimiento"),
                resultado.getDouble("precio_venta"),
                resultado.getString("ruc"),
                resultado.getString("razon_social")
        );
        return compraClientes;
    }
}
