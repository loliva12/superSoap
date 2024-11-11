package ar.edu.ubp.das.supermercadosoap.services;

import ar.edu.ubp.das.supermercadosoap.bean.ListaPrecios;
import ar.edu.ubp.das.supermercadosoap.bean.SucursalesRequest;
import ar.edu.ubp.das.supermercadosoap.repository.ListaPreciosRepository;
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
@WebService(serviceName = "ListaPreciosWS", targetNamespace =
        "http://services.supermercadosoap.das.ubp.edu.ar/")


public class ListaPreciosWS {

    @Autowired
    private ListaPreciosRepository listaPreciosRepository;

    @WebMethod(operationName = "obtenerListaPrecios")
    @RequestWrapper(localName = "obtenerListaPreciosRequest")
    @ResponseWrapper(localName = "obtenerListaPreciosResponse")
    @WebResult(name = "ListaPrecios")

    public List<ListaPrecios> obtenerListaPrecios() {
        return listaPreciosRepository.getListaPrecios();
    }

    @Autowired
    private SucursalesInfoRepository sucursalesInfoRepository;

    @WebMethod(operationName = "obtenerInfoSucursales")
    @RequestWrapper(localName = "obtenerInfoSucursalesRequest")
    @ResponseWrapper(localName = "obtenerInfoSucursalesResponse")
    @WebResult(name = "InfoSucursales")
    public List<SucursalesRequest> obtenerInfoSucursales() {
        return sucursalesInfoRepository.getInfoSucursales();
    }

}


