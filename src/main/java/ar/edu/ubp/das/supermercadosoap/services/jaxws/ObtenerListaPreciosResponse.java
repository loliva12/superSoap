
package ar.edu.ubp.das.supermercadosoap.services.jaxws;

import java.util.List;
import ar.edu.ubp.das.supermercadosoap.bean.ListaPrecios;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerListaPreciosResponse", namespace = "http://services.supermercadosoap.das.ubp.edu.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerListaPreciosResponse", namespace = "http://services.supermercadosoap.das.ubp.edu.ar/")
public class ObtenerListaPreciosResponse {

    @XmlElement(name = "ListaPrecios", namespace = "")
    private List<ListaPrecios> listaPrecios;

    /**
     * 
     * @return
     *     returns List<ListaPrecios>
     */
    public List<ListaPrecios> getListaPrecios() {
        return this.listaPrecios;
    }

    /**
     * 
     * @param listaPrecios
     *     the value for the listaPrecios property
     */
    public void setListaPrecios(List<ListaPrecios> listaPrecios) {
        this.listaPrecios = listaPrecios;
    }

}
