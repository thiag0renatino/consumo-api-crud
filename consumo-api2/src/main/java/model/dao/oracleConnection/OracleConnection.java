package model.dao.oracleConnection;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.credentials.Credentials;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class OracleConnection {

	private static OracleConnection instance;
	
	private OracleDataSource ods;
	
	private OracleConnection() {
		try {
			ods = new OracleDataSource();
			ods.setURL(Credentials.url);
			ods.setUser(Credentials.user);
			ods.setPassword(Credentials.password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static OracleConnection getInstance() {
			
			if (instance == null) {
				instance = new OracleConnection();
			}
			
			return instance;
		}
	
	public Connection getConnection() {
		try {
			
			System.out.println("\nConectando...");
			return ods.getConnection();
		} catch (SQLException e) {
			
			new SQLException("Erro ao obter conexão!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	

}
