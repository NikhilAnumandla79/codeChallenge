package com.playermanagement.utility;

import java.util.Comparator;

import com.playermanagement.model.Player;

public class MyComp implements Comparator<Player> {


	@Override
	public int compare(Player o1, Player o2) {
		
		int name = o1.getName().compareTo(o2.getName());
		int age =o1.getAge()>=o2.getAge()?1:-1;
		return (name==0)?age:name;
	}

}
