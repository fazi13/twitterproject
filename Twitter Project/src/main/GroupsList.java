package main;

import java.util.ArrayList;

public class GroupsList {
	private static ArrayList<Group> allGroups;
	
	public static void addGroup(Group g){
		allGroups.add(g);
	}
	
	public static Group getGroup(int id){
		return allGroups.get(id);
	}
}
