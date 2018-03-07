package com.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.user.dto.UserDTO;
import com.user.service.UserService;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserService userService;

	public UserController() {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
			UnavailableException {
		String actions = request.getParameter("action");

		if (actions.equalsIgnoreCase("view")) {
			try

			{
				List<UserDTO> userList = userService.getAllUsers();
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("userlist.jsp");
				request.setAttribute("userss", userList);
				requestDispatcher.forward(request, response);
			} catch (SQLException sql) {
				System.out.println(sql.getMessage());
			}
		} else if (actions.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			UserDTO users=userService.getUsersById(id);
			RequestDispatcher requests=request.getRequestDispatcher("users.jsp");
			request.setAttribute("userss", users);
			requests.forward(request, response);
			
		} else  if(actions.equalsIgnoreCase("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			userService.deleteUser(id);
			try{
			List<UserDTO> userList=userService.getAllUsers();
			RequestDispatcher RequestD=request.getRequestDispatcher("userlist.jsp");
			request.setAttribute("userss", userList);
			RequestD.forward(request, response);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	protected void doPost(HttpServletRequest requests,
			HttpServletResponse responses) throws IOException, ServletException {
		String id = requests.getParameter("id");
		String firstName = requests.getParameter("firstName");
		String lastName = requests.getParameter("lastName");
		String address = requests.getParameter("address");
		UserDTO userDTO = new UserDTO();

		if (!StringUtils.isNullOrEmpty(id)) { // yaha bhi samj me nhi aaya
			userDTO.setId(Integer.parseInt(id));
		}
		userDTO.setFirstName(firstName);
		userDTO.setLastName(lastName);
		userDTO.setAddress(address);

		userService.saveUser(userDTO);

		RequestDispatcher requestDispatcher = requests.getRequestDispatcher("userlist.jsp");
			try {
				requests.setAttribute("userss", userService.getAllUsers());
				requestDispatcher.forward(requests, responses);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
