package kr.or.connect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/sequelize?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC"; // SSL사용
																																	// 안하기
																																	// 위해
	private static String dbuser = "tester";
	private static String dbpassword = "1111";

	public List<Role> getRole() {
		List<Role> ret = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM jdbcex order by role_id desc";

		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					ret.add(role);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return ret;
	}
// 오버로딩
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver"); // Driver Loading 수행
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			String sql = "SELECT role_id, description FROM jdbcex WHERE role_id=?";
			ps = conn.prepareStatement(sql); // 쿼리 전체가 아닌 ?부분만 바인딩 및 변경
			ps.setInt(1, roleId); // 첫번째(idx 1) 물음표에 roleId를 할당한다
			rs = ps.executeQuery();

			if (rs.next()) {
				String description = rs.getString(1);
				int id = rs.getInt("roleId");
				role = new Role(id, description);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

		return role;
	}

	public int addRole(Role role) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO jdbcex (role_id, description) VALUES (?,?)";

		// java 7 이상에서 적용 가능한 문법으로 명시적으로 close를 호출하지 않아도, 자동으로 호출해준다고 한다
		// try-with-resources라 부른다(자동 리소스 닫기)
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) { //try ()안의 변수는 try 내에서 사용가능하며, try문을 벗어나면 close()를 call한다
																	 //auto closable한 변수만 close 되는 것은 함정
			ps.setInt(1, role.getRoldId());
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return insertCount;
	}

}
