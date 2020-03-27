package kr.or.connect.jdbcexam;

import kr.or.connect.dao.RoleDao;
import kr.or.connect.jdbexam.dto.Role;

public class jdbcexam2 {
public static void main(String[] args) {
	int roleId=120;
	String description = "CEO";
	
	Role role = new Role(roleId, description);
	
	RoleDao dao = new RoleDao();
	
	int insertCount = dao.addRole(role);
	
	System.out.println(insertCount);
}
}
