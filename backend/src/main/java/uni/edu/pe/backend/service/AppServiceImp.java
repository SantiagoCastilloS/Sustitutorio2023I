package uni.edu.pe.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.backend.dao.AppDao;
import uni.edu.pe.backend.dto.Compra;
import uni.edu.pe.backend.dto.CompraClientes;
import uni.edu.pe.backend.dto.Cupon;

import java.util.List;

@Service
@Transactional
public class AppServiceImp implements AppService {
    @Autowired
    private AppDao dao;

    @Override
    public List<CompraClientes> reporteCompraClientes() {
        return dao.reporteCompraClientes();
    }

    @Override
    public Cupon insertarCupon(Cupon cupon) {
        return dao.insertarCupon(cupon);
    }

    @Override
    public Compra actualizarCompra(Compra compra) {
        return dao.actualizarCompra(compra);
    }
}
