
package ar.edu.ubp.das.supermercadosoap.services.jaxws;

import java.util.List;
import ar.edu.ubp.das.supermercadosoap.bean.SucursalesRequest;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerInfoSucursalesResponse", namespace = "http://services.supermercadosoap.das.ubp.edu.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerInfoSucursalesResponse", namespace = "http://services.supermercadosoap.das.ubp.edu.ar/")
public class ObtenerInfoSucursalesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<SucursalesRequest> _return;

    /**
     * 
     * @return
     *     returns List<SucursalesRequest>
     */
    public List<SucursalesRequest> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<SucursalesRequest> _return) {
        this._return = _return;
    }

}
