package br.com.caelum.agenda.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			
			System.out.println("Abrindo a conexão....");
			
			Connection conexao = new ConnectionFactory().getConnection();
			request.setAttribute("conexao", conexao);
			
			chain.doFilter(request, response);
			
			conexao.close();
			
			System.out.println("Fechando a conexão....");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
