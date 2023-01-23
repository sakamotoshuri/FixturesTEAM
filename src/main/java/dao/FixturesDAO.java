package dao;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Fixtures;
public class FixturesDAO {
	
	// DBへのConnectionを取得（本番環境/テスト環境 切り替え用）
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
	// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
	public static int registerFixtures(Fixtures fix) {
		
		String sql = "INSERT INTO fixtures VALUES(?, ?, ?, ?, ?)";
		// return用の変数
		int result = 0;
		
		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			pstmt.setInt(1, fix.getFixtures_id());
			pstmt.setString(2, fix.getFixtures_name());
			pstmt.setInt(3, fix.getQuantity());
			pstmt.setString(4, fix.getCategory());
			pstmt.setString(5, fix.getContent());
			result = pstmt.executeUpdate();
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
	public static int DeleteFixtures(int fixtures_id) {
		
		String sql = "DELETE FROM fixtures WHERE fixtures_id = ?";
		int result = 0;
		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			pstmt.setInt(1,fixtures_id );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return  result;
	}	
	
}