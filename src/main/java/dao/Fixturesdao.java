package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Fixturesdto;

public class Fixturesdao {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	
	public static List<Fixturesdto> SearchProductName(String serch) {
		String serchname="%"+serch+"%";
		
		String sql = "select * from fixturres where fixtures_name LIKE ? ";
		List<Fixturesdto>result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,serchname);
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					int fixtures_id = rs.getInt("fixtures_id");
					String fixtures_name = rs.getString("fixtures_name");
					int quantity = rs.getInt("quantity");
					String category = rs.getString("category");
					String content = rs.getString("content");
					Fixturesdto fixtures = new Fixturesdto( fixtures_id,fixtures_name , quantity ,category, content);
					
					result.add(fixtures);
					
										
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件商品を検索しました。");
		}
		return result;
	}
	public static List<Fixturesdto> SearchFixturesCategory(String serch) {
		String serchname="%"+serch+"%";
		
		String sql = "select * from fixtures where category LIKE ? ";
		List<Fixturesdto>result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,serchname);
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					int fixtures_id = rs.getInt("fixtures_id");
					String fixtures_name = rs.getString("fixtures_name");
					int quantity = rs.getInt("quantity");
					String category = rs.getString("category");
					String content = rs.getString("content");
					Fixturesdto fixtures = new Fixturesdto( fixtures_id,fixtures_name , quantity ,category, content);
					
					result.add(fixtures);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件商品を検索しました。");
		}
		return result;
	}
	
	public static List<Fixturesdto> SearchProductId(int serch) {
		int serchname=serch;
		
		String sql = "select * from fixtures where fixtures_id = ? ";
		List<Fixturesdto>result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1,serchname);
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					int fixtures_id = rs.getInt("fixtures_id");
					String fixtures_name = rs.getString("fixtures_name");
					int quantity = rs.getInt("quantity");
					String category = rs.getString("category");
					String content = rs.getString("content");
					Fixturesdto fixtures = new Fixturesdto( fixtures_id,fixtures_name , quantity ,category, content);
					
					result.add(fixtures);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件商品を検索しました。");
		}
		return result;
	}
	public static List<Fixturesdto> selectAllFixtures() {
		String sql = "select * from fixtures";
		List<Fixturesdto>result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					int fixtures_id = rs.getInt("fixtures_id");
					String fixtures_name = rs.getString("fixtures_name");
					int quantity = rs.getInt("quantity");
					String category = rs.getString("category");
					String content = rs.getString("content");
					Fixturesdto fixtures = new Fixturesdto( fixtures_id,fixtures_name , quantity ,category, content);
					
					result.add(fixtures);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件商品を検索しました。");
		}
		return result;
	}
	
	
}
