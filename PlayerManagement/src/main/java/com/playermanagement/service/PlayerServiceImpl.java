package com.playermanagement.service;

import java.util.Collections;
import java.util.List;

import com.playermanagement.dao.PlayerDao;
import com.playermanagement.dao.impl.PlayerDaoImpl;
import com.playermanagement.exceptions.MyException;
import com.playermanagement.model.Player;
import com.playermanagement.utility.MyComp;

public class PlayerServiceImpl implements PlayerService{
	PlayerDao playerDao = new PlayerDaoImpl();
	@Override
	public int addPlayer(Player player) throws MyException {
		try {
			return playerDao.insertPlayer(player);
		} catch (MyException e) {
			throw new MyException("choose another id :",e);
		}
	}
	@Override
	public List<Player> getPlayers(String teamName) {
		List<Player> players = playerDao.getPlayers(teamName);
		Collections.sort(players,new MyComp());
		return players;
	}
	@Override
	public List<Player> getAllPlayers() {
		List<Player> players = playerDao.getAllPlayers();
		Collections.sort(players,new MyComp());
		return players;
	}

}
