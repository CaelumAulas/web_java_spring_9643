package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection conexao;
	
	public ContatoDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato novoContato) {
		
		String sql = "insert into contatos (nome, endereco, email, dataNascimento)  "
				+ "values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, novoContato.getNome());
			stmt.setString(2, novoContato.getEndereco());
			stmt.setString(3, novoContato.getEmail());
			stmt.setDate(4, new java.sql.Date(novoContato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			
			stmt.close();
			
			System.out.println("adicionando!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Contato> getLista() {
		
		String sql = "select * from contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
		
			while(result.next()) {
				
				Contato contato = new Contato();
				contato.setId(result.getLong("id"));
				contato.setNome(result.getString("nome"));
				contato.setEmail(result.getString("email"));
				contato.setEndereco(result.getString("endereco"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(result.getDate("dataNascimento"));
	
				contato.setDataNascimento(cal);
				contatos.add(contato);
			}
			
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return contatos;
	}

}
