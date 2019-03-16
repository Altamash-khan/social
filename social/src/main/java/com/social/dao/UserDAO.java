package com.social.dao;

import com.social.model.UserDetail;

public interface UserDAO
{
	public boolean registerUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public boolean deleteUser(UserDetail user);
    public UserDetail getUser(String username);
    public boolean makeOffline(UserDetail user);
    public boolean makeOnline(UserDetail user);
    public boolean approveUser(UserDetail user);
    public boolean rejectUser(UserDetail user);
}
