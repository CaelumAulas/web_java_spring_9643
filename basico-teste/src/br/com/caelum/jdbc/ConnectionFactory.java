package br.com.caelum.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			
			Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fj21?useSSL=false", "root", "caelum123");
		
			System.out.println("Conexao aberta!");
			
			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
