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

public class FixturesDAO {

	// DBへのConnectionを取得(参考：これまで教えていたやり方)
//	private static Connection getConnection() throws URISyntaxException, SQLException {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	    String username = "postgres";
//	    String password = "morijyobi";
//	    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
//
//	    return DriverManager.getConnection(dbUrl, username, password);
//	}
	
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
	
	// 備品のデータを全件取得する
	public static List<Fixtures> Itiran()  {
		
		String sql = "SELECT * FROM fixtures";
		
		// 返却用変数
		List<Fixtures> result = new ArrayList<>();

		
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

					Fixtures fixtures = new Fixtures(fixtures_id, fixtures_name, quantity, category, content);
					
					result.add(fixtures);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} 

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
}
