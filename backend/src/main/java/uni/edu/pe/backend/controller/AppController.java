package uni.edu.pe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.backend.dto.Compra;
import uni.edu.pe.backend.dto.Cupon;
import uni.edu.pe.backend.dto.rest.RespuestaCompraClientes;
import uni.edu.pe.backend.service.AppService;

@RestController
@CrossOrigin(origins = {"*"})
public class AppController {
    @Autowired
    private AppService service;
    @RequestMapping(
            value="/insertarCupon",
            method = RequestMethod.POST
    )
    public Cupon agregarEquipo(@RequestBody Cupon cupon){
        return service.insertarCupon(cupon);
    }
    @RequestMapping(
            value="/actualizarCompra",
            method = RequestMethod.POST
    )
    public Compra actualizarCompra(@RequestBody Compra compra){
        return service.actualizarCompra(compra);
    }
    @RequestMapping(
            value="/reporteCompraClientes",
            method = RequestMethod.POST
    )
    public @ResponseBody RespuestaCompraClientes reporteCompraClientes(){
        RespuestaCompraClientes rpta = new RespuestaCompraClientes();
        rpta.setCompraClientes(service.reporteCompraClientes());
        return rpta;
    }


}
