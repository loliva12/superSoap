package ar.edu.ubp.das.supermercadosoap.repository;
import ar.edu.ubp.das.supermercadosoap.bean.SucursalesRequest;
import ar.edu.ubp.das.supermercadosoap.components.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SucursalesInfoRepository {

    @Autowired
    private SimpleJdbcCallFactory jdbcCallFactory;

    public List<SucursalesRequest> getInfoSucursales() {
        // Llama al procedimiento almacenado para obtener la información de sucursales
        return jdbcCallFactory.executeQuery("get_info_sucursales", "dbo", "sucursales", SucursalesRequest.class);
    }
}
