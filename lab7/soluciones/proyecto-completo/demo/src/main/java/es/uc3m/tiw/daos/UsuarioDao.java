package es.uc3m.tiw.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import es.uc3m.tiw.dominios.Usuario;
/**
* @author David Palomar
*/
@RestResource(path="usuarios",rel="usuarios")
public interface UsuarioDao extends CrudRepository<Usuario, Long> {

	List<Usuario> findAll();
	Usuario findByNombre(String nombre);
}
