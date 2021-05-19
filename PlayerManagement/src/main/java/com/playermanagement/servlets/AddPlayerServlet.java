package com.playermanagement.servlets;

import java.io.IOException;

import com.playermanagement.exceptions.MyException;
import com.playermanagement.model.Player;
import com.playermanagement.service.PlayerService;
import com.playermanagement.service.PlayerServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPlayerServlet
 */
@WebServlet("/addPlayer")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int playerId = Integer.parseInt(request.getParameter("playerId"));
		String playerName = request.getParameter("playerName");
		int playerAge =  Integer.parseInt(request.getParameter("playerAge"));
		String playerGender = request.getParameter("playerGender");
		String playerTeam = request.getParameter("playerTeam");
		Player player = new Player(playerId, playerName, playerAge, playerGender, playerTeam);
		PlayerService playerService= new PlayerServiceImpl();
		try {
			if(playerService.addPlayer(player)>0) {
				response.getWriter().write(player.getName() +" is registered successfully");
			}else {
				response.getWriter().write(" Registration Failed ");
			}
		} catch (MyException e) {
			response.getWriter().write(" Registration Failed Id already exits");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
