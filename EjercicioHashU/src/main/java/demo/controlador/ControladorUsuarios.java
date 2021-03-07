package demo.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.Usuarios;
import demo.model.negocio.GestorUsuarios;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private GestorUsuarios gestorUsuarios;
	
	@GetMapping("sign_up")
	private String signUpUser() {
		return "registrou";
	}
	
	@GetMapping("log_in")
	private String logInUser() {
		return "loginu";
	}
	
	@PostMapping("signUp")
	private String signup(@RequestParam("usuario") String username,@RequestParam("password") String password, Model model)throws NoSuchAlgorithmException{
		
		String hash = hashPassword(password);
		
		Usuarios user = new Usuarios();
		user.setUsuario(username);
		user.setPassword(hash);
		
		gestorUsuarios.altaUser(user);
		return "inicior";
	}
	


	@PostMapping("login")
	private String login(@RequestParam("usuario") String username,@RequestParam("password") String password, Model model)throws NoSuchAlgorithmException{
		
		
		String hash = hashPassword(password);
		
		Usuarios user = new Usuarios();
		user.setUsuario(username);
		user.setPassword(hash);
		
		boolean validado = gestorUsuarios.validarUsuario(user); 
		

		if (validado) {
			
			return "iniciol";
			
		} else {

			return "erroru";
		}
	}
	
	private String hashPassword(String password) throws NoSuchAlgorithmException{
		
		byte[]passwordd = password.getBytes();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(passwordd);
		
		byte[] resumen = md.digest();
		String mensajeHashHex = javax.xml.bind.DatatypeConverter.printHexBinary(resumen);
		
		return mensajeHashHex;
	}
	

}
