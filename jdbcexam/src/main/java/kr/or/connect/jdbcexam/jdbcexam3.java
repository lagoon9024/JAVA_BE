package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.dao.RoleDao;
import kr.or.connect.jdbexam.dto.Role;

public class jdbcexam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao= new RoleDao() ;
		
		List<Role> list = dao.getRole();
		
		for(Role role:list) {
			System.out.println(role);
		}
		
	}

}
