package com.Tabiby.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.UsersDao;
import com.Tabiby.Model.Users;

/**
 * Created by zamalek on 8/12/2016.
 */
@Service("userService")
public class UsersServiceImp implements UsersService{

    @Autowired
   private UsersDao userDao;


    public UsersDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UsersDao uDao) {
        userDao = uDao;
    }


    @Override
    @Transactional
    public void addUsers(Users user) {

        this.userDao.addUsers(user);

    }

	@Override
	@Transactional
	public List<Users> searchUserName(String userName) {
	 return	this.userDao.searchUserName(userName);
	}

	@Override
	@Transactional
	public List<Users> searchUserEmail(String email) {
		
		return this.userDao.searchUserEmail(email);
	}

	@Override
	@Transactional
	public List<Users> searchUserMobile(String mobile) {
		// TODO Auto-generated method stub
		return this.userDao.searchUserMobile(mobile);
	}

	@Override
	@Transactional
	public List<Users> searchUserToken(String token , String userName) {
		return this.userDao.searchUserToken(token, userName);
	}

	@Override
	@Transactional
	public List<Users> searchUserAccount(String pass, String mobile) {
		return this.userDao.searchUserAccount(pass, mobile);
	}

	@Override
	@Transactional
	public boolean updateUser(Users users) {
		return this.userDao.updateUser(users);
	}
	@Override
	@Transactional
	public List<Users> searchUserVerified(String userName)
	{
		return this.userDao.searchUserVerified(userName);
	}
	@Override
	@Transactional
	public List<Users>getUsers(List<String>userName){
		return  this.userDao.getUsers(userName);
	}

	@Override
	@Transactional
	public List<Users> getUser(long id){
		return  this.userDao.getUser(id);
	}
	@Override
	@Transactional
	public List<Users> getUsers(){
		return this.userDao.getUsers();
	}
	@Override
	@Transactional
	public List<Users>searchForgetToken(String mobile , String token){
		return this.userDao.searchForgetToken(mobile, token);
	}
}
