package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	// todos os metodos http
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
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
			out.println("Erro de conversão da data");
			System.out.println("Ocorreu um erro:" + e);
			return;
//			throw new RuntimeException(e);
		}
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(novoContato);
		
		req.setAttribute("mensagem", "Enviando uma frase para a JSP!");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/contato-adicionado.jsp");
		dispatcher.forward(req, resp);
		
	}

}
