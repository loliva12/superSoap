package ar.edu.ubp.das.supermercadosoap.services;

import ar.edu.ubp.das.supermercadosoap.bean.SucursalesPrecios;
import ar.edu.ubp.das.supermercadosoap.repository.SucursalesPreciosRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@WebService
public class SucursalesPreciosWS {

    @Autowired
    private SucursalesPreciosRepository sucursalesPreciosRepository;

    @WebMethod
    public List<SucursalesPrecios> obtenerListaPrecios() {
        return sucursalesPreciosRepository.getListaPrecios();
    }
}
