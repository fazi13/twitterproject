package main;

import java.util.ArrayList;
import java.util.Collections;

public class UsersList {
	private static UsersList firstInstance = null;
	private static ArrayList<User> allUsers = new ArrayList<User>(0);
	
	private UsersList(){
		
	}
	
	public static UsersList getInstance(){
		if(firstInstance == null){
			firstInstance = new UsersList();
		}
		return firstInstance;
	}
	
	public static void addUser(User u) throws NewUserException{
		//if user exists already then throw an exception
		if(userExists(u.getUserID())){
			throw new NewUserException();
		}else{
			allUsers.add(u);
		}
	}
	
	public static int getNewUserID(){
		//add new user at the end
		return allUsers.size();
	}
	
	public static int getTotalUsers(){
		return allUsers.size();
	}
	
	public static String getUsername(int id){
		return allUsers.get(id).getUsername();
	}
	
	public static User getUser(int id){
		for(int i = 0; i < allUsers.size(); i++){
			if(allUsers.get(i).getUserID() == id){
				return allUsers.get(i);
			}
		}
		return null;
	}
	
	public static boolean userExists(int id){
		for(int i = 0; i < allUsers.size(); i++){
			if(allUsers.get(i).getUserID() == id){
				return true;
			}
		}
		return false;
	}
	
	//returns true if id not valid
	public static boolean checkIDs(){
		for(int i = 0; i < allUsers.size(); i++){
			User u1 = allUsers.get(i);
			if(u1.getUsername().equals(u1.getUsername().trim())){
				//if username == username.trim then no spaces do nothing
			}else{
				//not equal to trim so contains a space
				return true;
			}
			for(int j = 0; j < allUsers.size(); j++){
				if(i == j){
					//do nothing: don't check against itself
				}else{
					//check if id number used already
					User u2 = allUsers.get(j);
					if(u1.getUserID() == u2.getUserID()){
						//same id return true
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static User getLastUpdatedUser(){
		User u1 = allUsers.get(0);
		for(int i = 1; i < allUsers.size(); i++){
			User u2 = allUsers.get(i);
			if(u2.getLastUpdated() > u1.getLastUpdated()){
				//swap u1 with u2 if it is newer
				u1 = u2;
			}
		}
		return u1;
	}
}
