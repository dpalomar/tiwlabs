package es.uc3m.tiw;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

	List<Usuario> findAll();
	Usuario findByNombre(String nombre);
}
