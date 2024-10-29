
package ar.edu.ubp.das.supermercadosoap.endpoints;

import ar.edu.ubp.das.supermercadosoap.bean.ListaPrecios;
import ar.edu.ubp.das.supermercadosoap.bean.SucursalesRequest;
import ar.edu.ubp.das.supermercadosoap.services.SucursalesInfoWS;
import ar.edu.ubp.das.supermercadosoap.services.ListaPreciosWS;
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
    private SucursalesInfoWS sucursalesInfoWS;

    @Autowired
    private ListaPreciosWS listaPreciosWS;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerInfoSucursales")
    @ResponsePayload
    public ObtenerInfoSucursalesResponse obtenerInfoSucursales(@RequestPayload ObtenerInfoSucursales request) {
        List<SucursalesRequest> sucursales = sucursalesInfoWS.obtenerInfoSucursales();

        ObtenerInfoSucursalesResponse response = new ObtenerInfoSucursalesResponse();
        response.setReturn(sucursales);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerListaPrecios")
    @ResponsePayload
    public ObtenerListaPreciosResponse obtenerListaPrecios(@RequestPayload ObtenerListaPrecios request) {
        List<ListaPrecios> precios = listaPreciosWS.obtenerListaPrecios();

        ObtenerListaPreciosResponse response = new ObtenerListaPreciosResponse();
        response.setReturn(precios);
        return response;
    }
}
