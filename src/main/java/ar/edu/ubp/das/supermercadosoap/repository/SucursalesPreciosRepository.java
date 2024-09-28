package ar.edu.ubp.das.supermercadosoap.repository;
import ar.edu.ubp.das.supermercadosoap.bean.SucursalesPrecios;
import ar.edu.ubp.das.supermercadosoap.components.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SucursalesPreciosRepository {

    @Autowired
    private SimpleJdbcCallFactory jdbcCallFactory;

    public List<SucursalesPrecios> getListaPrecios() {
        // Llama al procedimiento almacenado para obtener la lista de precios
        return jdbcCallFactory.executeQuery("get_lista_precios", "dbo", "precios", SucursalesPrecios.class);
    }
}
