package main;

import java.util.ArrayList;
import java.util.Comparator;

public class Group implements Comparable<Group>, Comparator<Group>{
	private int id;
	private String groupname;
	private int parentGroup;
	private boolean subGroup;
	private ArrayList<Integer> userIDs;
	
	public Group(String name){
		id = GroupsList.getNewGroupID();
		groupname = name;
		//root group id = 0
		parentGroup = 0;
		subGroup = false;
	}
	
	public Group(String name, int pID) throws GroupNotExistException{
		//check if parent id exists
		if(GroupsList.groupExists(pID)){
			id = GroupsList.getNewGroupID();
			groupname = name;
			parentGroup = pID;
			subGroup = true;
		}else{
			throw new GroupNotExistException();
		}
	}
	
	public String getGroupname(){
		return groupname;
	}
	
	public int getParent(){
		return parentGroup;
	}
	
	public boolean isSubGroup(){
		return subGroup;
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
	
	public int getGroupID(){
		return id;
	}

	@Override
	public int compare(Group g1, Group g2) {
		// TODO Auto-generated method stub
		return g1.getGroupID() - g2.getGroupID();
	}

	@Override
	public int compareTo(Group g) {
		// TODO Auto-generated method stub
		return id - g.getGroupID();
	}
}
