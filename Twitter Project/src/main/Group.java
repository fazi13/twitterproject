package main;

import java.util.ArrayList;
import java.util.Comparator;

public class Group implements Comparable<Group>, Comparator<Group>{
	private int id;
	private String groupname;
	private Group parentGroup;
	private boolean subGroup;
	private long creationTime;
	private ArrayList<User> users;
	
	public Group(String name){
		id = GroupsList.getNewGroupID();
		groupname = name;
		//root group id = 0
		parentGroup = null;
		subGroup = false;
		users = new ArrayList<>();
		creationTime = System.currentTimeMillis();
	}
	
	public Group(String name, int pID) throws GroupNotExistException{
		//check if parent id exists
		if(GroupsList.groupExists(pID)){
			id = GroupsList.getNewGroupID();
			groupname = name;
			//convert id no to the group
			parentGroup = GroupsList.getGroup(pID);
			subGroup = true;
			users = new ArrayList<>();
			creationTime = System.currentTimeMillis();
		}else{
			throw new GroupNotExistException();
		}
	}
	
	public String getGroupname(){
		return groupname;
	}
	
	public Group getParent(){
		return parentGroup;
	}
	
	public long getCreationTime(){
		return creationTime;
	}
	
	public boolean isSubGroup(){
		return subGroup;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void addUser(User u){
		//first remove that user from the old group
		Group oldGroup = u.getGroup();;
		oldGroup.removeUser(u);
		//now add that user to this group
		users.add(u);
		u.setGroup(GroupsList.getGroup(id));
	}
	
	public void removeUser(User u){
		users.remove(u);
		u.setGroup(null);
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
	
	public String toString(){
		return groupname;
	}
}
