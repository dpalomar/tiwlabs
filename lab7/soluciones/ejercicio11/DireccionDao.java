package es.uc3m.tiw.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import es.uc3m.tiw.dominios.Direccion;

@RestResource(path="direcciones",rel="direcciones")
public interface DireccionDao extends CrudRepository<Direccion, Long> {


}
