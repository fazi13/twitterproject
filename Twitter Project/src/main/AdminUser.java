package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdminUser extends User{

	public AdminUser(String u) {
		super(u);
	}
	
	@Override
	public boolean isAdmin() {
		return true;
	}
	
	public int getTotalUsers(){
		return UsersList.getTotalUsers();
	}
	
	public int getTotalMessages(){
		return Message.getTotalMessages();
	}
	
	public String getPercentPositive(){
		BigDecimal bd = new BigDecimal(Message.getTotalPositive());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		//round to 2 decimal places and add % symbol
		return (bd.toString() + "%");
	}
}
