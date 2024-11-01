
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

    @XmlElement(name = "return", namespace = "")
    private List<ListaPrecios> _return;

    /**
     * 
     * @return
     *     returns List<ListaPrecios>
     */
    public List<ListaPrecios> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<ListaPrecios> _return) {
        this._return = _return;
    }

}
