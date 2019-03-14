package com.social.dao;

import java.util.List;

import com.social.model.Friend;

public interface FriendDAO 
{
	public boolean addFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
	public boolean updateFriend(Friend friend);
	public boolean approveFriend(Friend friend);
	public boolean rejectFriend(Friend friend);
	public Friend getFriend(int friendId);
	public List<Friend> getAllFriends();
	
}
