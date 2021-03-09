package demo.model.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.entidad.Users;
import demo.model.persistencia.DaoUsuario;


@Service
public class GestionUsers {
	
	@Autowired
	private DaoUsuario daoUsers;

	public void altaUser(Users user) {
		daoUsers.save(user);
		
	}

	public boolean validarUsuario(Users users) {
		
		Users usuarioAux = daoUsers.findByUserAndPassword(users.getUser(), users.getPassword());
		
		if (usuarioAux == null) {
			return false;
		} else {
			return true;
		}
	}

}
