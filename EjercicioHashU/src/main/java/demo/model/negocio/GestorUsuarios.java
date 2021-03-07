package demo.model.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Usuarios;
import demo.model.persistencia.DaoUsuarios;

@Service
public class GestorUsuarios {
	
	@Autowired
	private DaoUsuarios daoUsuario;

	public void altaUser(Usuarios user) {
		daoUsuario.save(user);
		
	}

	public boolean validarUsuario(Usuarios user) {
		
		Usuarios usuarioAux = daoUsuario.findByNombreAndPassword(user.getUsuario(), user.getPassword());
		
		if (usuarioAux == null) {
			return false;
		} else {
			return true;
		}
	}

}
