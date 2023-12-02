package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "da_java.mysql.dbaas.com.br"; // localhost
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
	}

	public Connection getConexao() {
		String url="jdbc:mysql://" + this.host + ":3306/" + this.banco + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conex�o com MYSQL n�o realizada");
			ex.printStackTrace();
		}
		return null;
	}

}
