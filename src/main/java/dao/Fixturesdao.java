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

import dto.Fixtures;
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
	
	// 引数の Product インスタンスを元にデータを1件INSERTするメソッド
	public static int registerFixtures(Fixtures fixt) {
		
		String sql = "INSERT INTO Fixtures VALUES(default, ?, ?, ?, ?)";
		// return用の変数
		int result = 0;
		
		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			pstmt.setString(1, fixt.getFixtures_name());
			pstmt.setInt(2, fixt.getQuantity());
			pstmt.setString(3, fixt.getCategory());
			pstmt.setString(4, fixt.getContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件商品を更新しました。");
		}
		return result;
	}
	
	public static List<Fixturesdto> SearchFixturesName(String serch) {
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
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	//削除
	
	
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

			System.out.println(result + "件削除しました。");
		}
		return  result;

			
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
