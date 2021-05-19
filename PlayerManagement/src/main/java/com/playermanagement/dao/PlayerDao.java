package com.playermanagement.dao;

import java.util.List;

import com.playermanagement.exceptions.MyException;
import com.playermanagement.model.Player;

public interface PlayerDao {
	public int insertPlayer(Player player) throws MyException;
	public List<Player> getPlayers(String teamName);
	public List<Player> getAllPlayers();
}
