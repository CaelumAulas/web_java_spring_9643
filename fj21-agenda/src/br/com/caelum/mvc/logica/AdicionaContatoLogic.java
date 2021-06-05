package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		
		Contato novoContato = new Contato();
		novoContato.setNome(nome);
		novoContato.setEndereco(endereco);
		novoContato.setEmail(email);
		
		try {
			// String > Date > Calendar
			Calendar cal = Calendar.getInstance();
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			cal.setTime(data);
			novoContato.setDataNascimento(cal);
			
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(novoContato);
		
		req.setAttribute("mensagem", "Enviando uma frase para a JSP!");
		
		return "/contato-adicionado.jsp";
	}

}
