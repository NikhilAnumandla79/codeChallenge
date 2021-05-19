package com.playermanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.playermanagement.dao.PlayerDao;
import com.playermanagement.exceptions.MyException;
import com.playermanagement.model.Player;
import com.playermanagement.utility.DbConnection;

public class PlayerDaoImpl implements PlayerDao{
	
	@Override
	public int insertPlayer(Player player) throws MyException {
		Connection con =null;
		PreparedStatement pstmt = null;
		if(checkIfIdExists(player.getId())) {
			throw new MyException("Player Id already exits");
		}
		try {
			con=new DbConnection().getConnection();
			String query = "INSERT INTO players VALUES(?,?,?,?,?)";
			pstmt= con.prepareStatement(query);
			pstmt.setInt(1, player.getId());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3,player.getAge());
			pstmt.setString(4,player.getGender());
			pstmt.setString(5, player.getTeam());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}
	public List<Player> getPlayers(String teamName){
		Connection con =null;
		PreparedStatement stmt = null;
		List<Player> players = new ArrayList<>();
		try {
			con=new DbConnection().getConnection();
			String query = "Select * from players where team_name=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, teamName);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("player_id");
				String name = rs.getString("player_name");
				int age = rs.getInt("player_age");
				String gender = rs.getString("player_gender");
				String team = rs.getString("team_name");
				players.add(new Player(id,name, age, gender, team));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return players;
	}
	@Override
	public List<Player> getAllPlayers() {
		Connection con =null;
		Statement stmt = null;
		List<Player> players = new ArrayList<>();
		try {
			con=new DbConnection().getConnection();
			String query = "Select * from players";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("player_id");
				String name = rs.getString("player_name");
				int age = rs.getInt("player_age");
				String gender = rs.getString("player_gender");
				String team = rs.getString("team_name");
				players.add(new Player(id,name, age, gender, team));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return players;
	}
	public boolean checkIfIdExists(int id) {
		Connection con =null;
		Statement stmt = null;
		try {
			con=new DbConnection().getConnection();
			String query = "Select * from players where player_id="+id;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
		
}
