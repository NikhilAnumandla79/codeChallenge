package com.playermanagement.service;

import java.util.List;

import com.playermanagement.exceptions.MyException;
import com.playermanagement.model.Player;

public interface PlayerService {
	public int addPlayer(Player player) throws MyException;
	public List<Player> getPlayers(String teamName);
	public List<Player> getAllPlayers();
}
