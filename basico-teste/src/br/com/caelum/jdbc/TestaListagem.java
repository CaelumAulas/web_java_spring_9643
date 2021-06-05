package br.com.caelum.jdbc;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaListagem {
	
	public static void main(String[] args) {
		
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> lista = contatoDao.getLista();
		
		for (Contato contato : lista) {
			System.out.println(contato);
		}
		
	}

}
