package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String formLogin() {
		return "login/formulario";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {

		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		if (dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}
