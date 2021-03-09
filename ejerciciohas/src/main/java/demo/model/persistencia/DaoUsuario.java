package demo.model.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import demo.model.entidad.Users;

@Repository //se esta creando un objeto de tipo DAOUsuario dentro del contexto de spring con el nombre de la clase y sera el encargado de hacer todas la fucniones de la base de datos 
public interface DaoUsuario extends JpaRepository<Users, Integer> {
	
	
	public Users findByUserAndPassword(String user, String password);
}
