package br.com.caelum.agenda.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/mvc/*") 
public class MeuFiltro implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Executando o MeuFiltro!");
		
		chain.doFilter(request, response);
		
		System.out.println("Executando o MeuFiltro na volta!");
		
	}

}
