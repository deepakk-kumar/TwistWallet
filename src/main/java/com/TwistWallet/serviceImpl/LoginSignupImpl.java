package com.TwistWallet.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TwistWallet.Entity.LoginEntity;
import com.TwistWallet.Entity.UserEntity;
import com.TwistWallet.dao.BaseDao;
import com.TwistWallet.dto.Login;
import com.TwistWallet.dto.User;
import com.TwistWallet.service.LoginSignupService;
import com.TwistWallet.utils.Response;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

@Service("LoginSignupService")
@Transactional
public class LoginSignupImpl implements LoginSignupService {
	
	@Autowired
	BaseDao baseDaoImpl;
	
	@Override
	public TwistWalletResponse login(TwistWalletRequest request) {
		TwistWalletResponse twistWalletResponse = new TwistWalletResponse();
		String email = request.getUser().getEmailAddress();
		String password = request.getLogin().getPassword();
		if(email == null || password == null || email.equals(null)){
			return null;
		}
		Map<String, Object> queryParams = new HashMap<>(2);
		queryParams.put("emailAddress", email);
		queryParams.put("password", password);
		UserEntity userEntityList = (UserEntity) baseDaoImpl.findWithNamedQueries("user.findByEmailAndPassword", UserEntity.class, queryParams);
		if(userEntityList != null){
			User user = new User();
			user.setUserId(userEntityList.getUserId());
			user.setEmailAddress(userEntityList.getEmailAddress());
			user.setNewUser(userEntityList.getNewUser());
			user.setFirstName(userEntityList.getFirstName());
			user.setLastName(userEntityList.getLastName());
			user.setAdmin(userEntityList.getAdmin());
			user.setMobileNumber(userEntityList.getMobileNumber());
			
			//getting Login id
			queryParams.clear();
			queryParams.put("uId", userEntityList.getUserId());
			LoginEntity loginEntity = (LoginEntity) baseDaoImpl.findWithNamedQueries("login.findByUserId", LoginEntity.class, queryParams);
			Login login = new  Login();
			login.setLoginId(loginEntity.getLoginId());
		twistWalletResponse.setLogin(login);
		twistWalletResponse.setUser(user);
		twistWalletResponse.setResultCode(Response.SUCCESS.getResultCode());
		twistWalletResponse.setResultDesc(Response.SUCCESS.getDesc());
		return twistWalletResponse;
		}
		twistWalletResponse.setResultCode(Response.FAILURE.getResultCode());
		twistWalletResponse.setResultDesc(Response.FAILURE.getDesc());
		return twistWalletResponse;
	}

	@Override
	public TwistWalletResponse reset(TwistWalletRequest request) {
		TwistWalletResponse twistWalletResponse = new TwistWalletResponse();
		String newPassword = request.getLogin().getPassword();
		int userId = request.getUser().getUserId();
		Map<String, Object> queryParams = new HashMap<>(2);
		queryParams.put("uId", userId);
		//
		LoginEntity loginEntity = (LoginEntity) baseDaoImpl.findWithNamedQueries("login.findByUserId", LoginEntity.class, queryParams);
		if(loginEntity != null){
			loginEntity.setPassword(newPassword);
			UserEntity userEntity = (UserEntity) baseDaoImpl.findWithNamedQueries("user.findByUserId", UserEntity.class, queryParams);
			userEntity.setNewUser(false);
		twistWalletResponse.setResultCode(Response.SUCCESS.getResultCode());
		twistWalletResponse.setResultDesc(Response.SUCCESS.getDesc());
		}else{
			twistWalletResponse.setResultCode(Response.FAILURE.getResultCode());
			twistWalletResponse.setResultDesc(Response.FAILURE.getDesc());
		}
		return twistWalletResponse;
	}

}
