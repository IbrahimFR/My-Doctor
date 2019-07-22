package com.Tabiby.service;


import java.util.List;

import com.Tabiby.Model.Users;

/**
 * Created by zamalek on 8/12/2016.
 */
public interface UsersService {
    public void addUsers(Users user);
    public List<Users>searchUserName(String userName);
    public List<Users>searchUserEmail(String email);
    public List<Users>searchUserMobile(String mobile);
    public List<Users>searchUserToken(String token , String userName);
    public List<Users>searchForgetToken(String mobile , String token);
    public List<Users>searchUserAccount(String pass, String mobile);
    public boolean updateUser(Users users);
    public List<Users> searchUserVerified(String userName);
    public List<Users>getUsers(List<String>userName);
    public List<Users> getUser(long id);
    public List<Users> getUsers();

}
