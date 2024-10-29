package ar.edu.ubp.das.supermercadosoap.services;

import ar.edu.ubp.das.supermercadosoap.bean.SucursalesRequest;
import ar.edu.ubp.das.supermercadosoap.repository.SucursalesInfoRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@WebService
public class SucursalesInfoWS {

    @Autowired
    private SucursalesInfoRepository sucursalesInfoRepository;

    @WebMethod
    public List<SucursalesRequest> obtenerInfoSucursales() {
        return sucursalesInfoRepository.getInfoSucursales();
    }
}
