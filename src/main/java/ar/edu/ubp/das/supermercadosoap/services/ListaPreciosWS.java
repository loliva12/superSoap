package ar.edu.ubp.das.supermercadosoap.services;

import ar.edu.ubp.das.supermercadosoap.bean.ListaPrecios;
import ar.edu.ubp.das.supermercadosoap.repository.ListaPreciosRepository;
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

public class ListaPreciosWS {

    @Autowired
    private ListaPreciosRepository listaPreciosRepository;

    @WebMethod
    public List<ListaPrecios> obtenerListaPrecios() {
        return listaPreciosRepository.getListaPrecios();
    }
}
