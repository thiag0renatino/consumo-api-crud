package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.oracleConnection.OracleConnection;
import model.vo.Filme;

public class FilmeDAO {
	
	private OracleConnection instance;
	
	private Connection conn;

	public FilmeDAO(OracleConnection instance) {
		this.instance = instance;
	}
	
	public boolean insert(Filme filme) {
		
		String sql = "INSERT INTO filme VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		conn = instance.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, filme.getTitle());
			ps.setInt(2, filme.getYear());
			ps.setString(3,filme.getGenre());
			ps.setString(4, filme.getRuntime());
			ps.setString(5, filme.getMetaScore());
			ps.setString(6, filme.getCountry());
			ps.setString(7, filme.getType());
			
			ps.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public boolean delete(String Title) {
		
		String sql = "DELETE FROM filme WHERE Title = ?";
		
		conn = instance.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Title);
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public boolean updateMetascore(String Metascore, String Title) {
		
		String sql = "UPDATE filme SET Metascore = ? WHERE Title = ?";
		
		conn = instance.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Metascore);
			ps.setString(2, Title);
			
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public Filme read(String Title) {
		
		String sql = "SELECT * FROM filme WHERE Title = ?";
		
		conn = instance.getConnection();
		
		Filme filme = new Filme();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Title);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			filme.setTitle(rs.getString("Title"));
			filme.setYear(rs.getInt("YearF"));
			filme.setGenre(rs.getString("Genre"));
			filme.setRuntime(rs.getString("Runtime"));
			filme.setMetaScore(rs.getString("Metascore"));
			filme.setCountry(rs.getString("Country"));
			filme.setType(rs.getString("Typef"));
			
						
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return filme;
	}
	
	
	
	
	
	
	
	
	

}
