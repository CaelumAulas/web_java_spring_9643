package br.com.caelum.jdbc;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	
	public static void main(String[] args) {
		
		Contato novoContato = new Contato();
		
		novoContato.setNome("Luan");
		novoContato.setEndereco("Rio de Janeiro");
		novoContato.setEmail("luan@caelum.com");
		novoContato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adiciona(novoContato);
		
		Contato novoContato2 = new Contato();
		novoContato2.setNome("Luan");
		novoContato2.setEndereco("Rio de Janeiro");
		novoContato2.setEmail("luan@caelum.com");
		novoContato2.setDataNascimento(Calendar.getInstance());
		
		contatoDao.adiciona(novoContato2);
		
		
		
		
		
		
	}

}
