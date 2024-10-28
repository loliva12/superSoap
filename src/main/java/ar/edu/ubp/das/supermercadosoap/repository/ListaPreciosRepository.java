package ar.edu.ubp.das.supermercadosoap.repository;
import ar.edu.ubp.das.supermercadosoap.bean.ListaPrecios;
import ar.edu.ubp.das.supermercadosoap.components.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListaPreciosRepository {

    @Autowired
    private SimpleJdbcCallFactory jdbcCallFactory;

    public List<ListaPrecios> getListaPrecios() {
        // Llama al procedimiento almacenado para obtener la lista de precios
        return jdbcCallFactory.executeQuery("get_lista_precios", "dbo", "precios", ListaPrecios.class);
    }
}
