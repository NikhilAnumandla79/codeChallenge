package com.playermanagement.servlets;

import java.io.IOException;
import java.util.List;

import com.playermanagement.model.Player;
import com.playermanagement.service.PlayerService;
import com.playermanagement.service.PlayerServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewPlayers
 */
@WebServlet("/viewPlayers")
public class ViewPlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewPlayers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		PlayerService playerService = new PlayerServiceImpl();
		if(teamName.equals("all")) {
			List<Player> players = playerService.getAllPlayers();
			request.setAttribute("team", "all");
			request.setAttribute("players", players);
			RequestDispatcher rd = request.getRequestDispatcher("teamplayers.jsp");
			rd.forward(request, response);
		}else {
			List<Player> players = playerService.getPlayers(teamName);
			request.setAttribute("team", teamName);
			request.setAttribute("players", players);
			System.out.println(players);
			System.out.println(teamName);
			RequestDispatcher rd = request.getRequestDispatcher("teamplayers.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
