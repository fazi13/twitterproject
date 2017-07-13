package main;

import java.util.ArrayList;

public class Group {
	private int id;
	private String groupname;
	private int parentGroup;
	private ArrayList<Integer> userIDs;
	
	public Group(int i, String name){
		id = i;
		groupname = name;
		//root group id = 0
		parentGroup = 0;
	}
	
	public Group(int i, String name, int pID){
		id = i;
		groupname = name;
		parentGroup = pID;
	}
	
	public String getGroupname(){
		return groupname;
	}
	
	public int getParent(){
		return parentGroup;
	}
	
	public ArrayList<Integer> getUsers(){
		return userIDs;
	}
	
	public void addUser(User u){
		//first remove that user from the old group
		int oldGroupID = u.getGroup();
		Group oldGroup = GroupsList.getGroup(oldGroupID);
		oldGroup.removeUser(u.getUserID());
		//now add that user to this group
		userIDs.add(u.getUserID());
	}
	
	public void removeUser(int id){
		//remove user with that id
		userIDs.remove(Integer.valueOf(id));
	}
}
