package kr.or.connect.jdbcexam;

import kr.or.connect.dao.RoleDao;
import kr.or.connect.jdbexam.dto.Role;

public class jdbcexam1 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(2);
		System.out.println(role);
	}
}
