package demo.model.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.Usuarios;

@Repository
public interface DaoUsuarios extends JpaRepository<Usuarios, Integer> {

	public Usuarios findByNombreAndPassword(String usuario, String password);


}
