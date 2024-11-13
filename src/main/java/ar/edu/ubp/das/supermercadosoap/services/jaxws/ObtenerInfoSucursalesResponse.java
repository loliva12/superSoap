
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

    @XmlElement(name = "InfoSucursales", namespace = "")
    private List<SucursalesRequest> infoSucursales;

    /**
     * 
     * @return
     *     returns List<SucursalesRequest>
     */
    public List<SucursalesRequest> getInfoSucursales() {
        return this.infoSucursales;
    }

    /**
     * 
     * @param infoSucursales
     *     the value for the infoSucursales property
     */
    public void setInfoSucursales(List<SucursalesRequest> infoSucursales) {
        this.infoSucursales = infoSucursales;
    }

}
