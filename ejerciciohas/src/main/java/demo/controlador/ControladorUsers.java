package demo.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.entidad.Users;
import demo.model.negocio.GestionUsers;

@Controller
public class ControladorUsers {
	
	@Autowired
	private GestionUsers gestionUsers;
	
	@GetMapping("sign_up")
	private String signUpUser() {
		return "registrou";
	}
	
	@GetMapping("log_in")
	private String logInUser() {
		return "loginu";
	}
	
	
	@PostMapping("signUp")
	public String signup(@RequestParam("usuario") String username, @RequestParam("password") String password, Model model) throws NoSuchAlgorithmException{
		
		String hash = hashPassword(password);
		
		Users user = new Users();
		user.setUser(username);
		user.setPassword(hash);
		
		gestionUsers.altaUser(user);
		
		return "inicior";
	}
	
	@PostMapping("login")
	public String login(@RequestParam("usuario") String username,@RequestParam("password") String password, Model model)throws NoSuchAlgorithmException{
		
		
		String hash = hashPassword(password);
		
		Users users = new Users();
		users.setUser(username);
		users.setPassword(hash);
		
		boolean validado = gestionUsers.validarUsuario(users); 
		

		if (validado) {
			
			return "iniciol";
			
		} else {

			return "erroru";
		}
	}
	
	@GetMapping("volver")
	private String volverInicio() {
		return "../static/psp";
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		
		byte[]passwordd = password.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(passwordd);
		
		byte[] resumen = md.digest();
		String mensajeHashHex = javax.xml.bind.DatatypeConverter.printHexBinary(resumen);
		
		return mensajeHashHex;
	}
	

}
