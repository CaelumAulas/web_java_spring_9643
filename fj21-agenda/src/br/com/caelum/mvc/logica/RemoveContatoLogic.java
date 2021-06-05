package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection conexao = (Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(conexao);
		dao.exclui(contato);
		
		System.out.println("Excluindo contato... ");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
