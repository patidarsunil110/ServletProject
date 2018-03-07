package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.dto.UserDTO;
import com.user.util.DbUtil;

public class UserDao {
	int i = 0;
	private Connection conn;

	public UserDao() {
		conn = DbUtil.getConnection();
	}

	public List<UserDTO> getAllUsers() {
		
		List<UserDTO> users = new ArrayList<UserDTO>();
		try {
		PreparedStatement stmt = conn.prepareStatement("select * from jspservlet");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(rs.getInt("id"));
			userDTO.setFirstName(rs.getString("firstName"));
			userDTO.setLastName(rs.getString("lastName"));
			userDTO.setAddress(rs.getString("address"));
			users.add(userDTO);

		}
		rs.close();
		stmt.close();
		} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
		return users;
	}
	public int saveUser(UserDTO userDTO) {
		try {
			String sql="insert into jspservlet(firstname,lastname,address) values(?,?,?)";
			PreparedStatement stmts=conn.prepareStatement(sql);
			stmts.setString(1, userDTO.getFirstName());
			stmts.setString(2, userDTO.getLastName());
			stmts.setString(3, userDTO.getAddress());
			
			int i=stmts.executeUpdate();
			System.out.println("Record inserted "+i);
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
		return i;
	}

	public int updateUser(UserDTO userDTO) {
		try {
			String sql = "update jspservlet set firstname=?, lastname=?, address=? where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userDTO.getFirstName());
			stmt.setString(2, userDTO.getLastName());
			stmt.setString(3, userDTO.getAddress());
			stmt.setInt(4, userDTO.getId());
			
			i = stmt.executeUpdate();
			System.out.println("Updated Records: "+i);
			return i;
		} catch (SQLException e) {
			System.out.println("error : "+e.getMessage());
		}
		return i;
	}

	public UserDTO getUserById(int id) {
		UserDTO userDto=new UserDTO();
		try {
			PreparedStatement stmt=conn.prepareStatement("select * from jspservlet where id=?");
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				userDto.setId(rs.getInt("id"));
				userDto.setFirstName(rs.getString("firstName"));
				userDto.setLastName(rs.getString("lastName"));
				userDto.setAddress(rs.getString("address"));
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return userDto;
	}

	public int deleteUser(int id) {
		try {
			String sql="delete from jspservlet where id=?";
			PreparedStatement stmts=conn.prepareStatement(sql);
			stmts.setInt(1, id);
			i=stmts.executeUpdate();
			System.out.println("Record Deleted "+i);
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return i;
	}
}
