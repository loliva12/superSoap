package ar.edu.ubp.das.supermercadosoap.endpoints;

import ar.edu.ubp.das.supermercadosoap.bean.ListaPrecios;
import ar.edu.ubp.das.supermercadosoap.bean.SucursalesRequest;
import ar.edu.ubp.das.supermercadosoap.services.SupermercadoWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ar.edu.ubp.das.supermercadosoap.services.jaxws.*;

import java.util.List;

@Endpoint
public class SupermercadoEndpoint {

    private static final String NAMESPACE_URI = "http://services.supermercadosoap.das.ubp.edu.ar/";

    @Autowired
    private SupermercadoWS supermercadoWS;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerListaPrecios")
    @ResponsePayload
    public ObtenerListaPreciosResponse obtenerListaPrecios(@RequestPayload ObtenerListaPrecios request) {
        // Llama al método del servicio para obtener los datos
        List<ListaPrecios> precios = supermercadoWS.obtenerListaPrecios();

        // Construye la respuesta
        ObtenerListaPreciosResponse response = new ObtenerListaPreciosResponse();
        response.setListaPrecios(precios);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerInfoSucursales")
    @ResponsePayload
    public ObtenerInfoSucursalesResponse obtenerInfoSucursales(@RequestPayload ObtenerInfoSucursales request) {
        // Llama al método del servicio para obtener la información de las sucursales
        List<SucursalesRequest> sucursales = supermercadoWS.obtenerInfoSucursales();

        // Construye la respuesta
        ObtenerInfoSucursalesResponse response = new ObtenerInfoSucursalesResponse();
        response.setInfoSucursales(sucursales);
        return response;
    }
}
