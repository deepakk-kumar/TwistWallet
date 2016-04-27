package com.TwistWallet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TwistWallet.Entity.UserEntity;
import com.TwistWallet.dao.BaseDao;
import com.TwistWallet.dto.User;
import com.TwistWallet.service.UserService;
import com.TwistWallet.utils.Response;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	BaseDao baseDaoImpl;
	
	@Override
	public TwistWalletResponse createUser(TwistWalletRequest request) {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmailAddress(request.getUser().getEmailAddress());
		userEntity.setFirstName(request.getUser().getFirstName());
		userEntity.setLastName(request.getUser().getLastName());
		userEntity.setMobileNumber(request.getUser().getMobileNumber());
		userEntity.setPassword(request.getUser().getPassword());
		userEntity.setAdmin(request.getUser().isAdmin());
		userEntity = (UserEntity) baseDaoImpl.save(userEntity);
		
		TwistWalletResponse response = new TwistWalletResponse();
		
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setEmailAddress(userEntity.getEmailAddress());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setAdmin(userEntity.getAdmin());
		response.setUser(user);
		response.setResultCode(Response.SUCCESS.getResultCode());
		response.setResultDesc(Response.SUCCESS.getDesc());
		return response;
	}

}
