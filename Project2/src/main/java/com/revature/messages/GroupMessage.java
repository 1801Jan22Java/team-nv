package com.revature.messages;

import com.revature.beans.Group;

public class GroupMessage {
	
	public GroupMessage(Group g) {
		super();
		this.groupName = g.getGroupName();
		this.groupDescription = g.getGroupDescription();
		this.groupId = g.getId();
		if(g.getGroupLeader() != null){
			this.groupLeader = g.getGroupLeader().getId();
		}
	}
	private String groupName;
	private String groupDescription;
	private String groupLeader;
	private int groupId;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public String getGroupLeader() {
		return groupLeader;
	}
	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public static void main(String[] args) {
		Group g = new Group("wat", "wat", "wat");
		System.out.println(g.getGroupLeader().getId());
		System.out.println(new GroupMessage(g).groupLeader);
	}
}
