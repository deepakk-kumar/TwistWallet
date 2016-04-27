package com.TwistWallet.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TwistWallet.Entity.UserEntity;
import com.TwistWallet.dao.BaseDao;
import com.TwistWallet.service.LoginSignupService;
import com.TwistWallet.utils.Response;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

@Service("LoginSignupService")
public class LoginSignupImpl implements LoginSignupService {
	
	@Autowired
	BaseDao baseDaoImpl;
	
	@Override
	public TwistWalletResponse login(TwistWalletRequest request) {
		TwistWalletResponse twistWalletResponse = new TwistWalletResponse();
		String email = request.getUser().getEmailAddress();
		String password = request.getUser().getPassword();
		Map<String, Object> queryParams = new HashMap<>(2);
		queryParams.put("emailAddress", email);
		queryParams.put("password", password);
		List<UserEntity> userEntityList = (List<UserEntity>) baseDaoImpl.findWithNamedQuery("user.findByEmailAndPassword", UserEntity.class, queryParams);
		if(userEntityList != null && userEntityList.size()!=0){
		twistWalletResponse.setResultCode(Response.SUCCESS.getResultCode());
		twistWalletResponse.setResultDesc(Response.SUCCESS.getDesc());
		return twistWalletResponse;
		}
		twistWalletResponse.setResultCode(Response.FAILURE.getResultCode());
		twistWalletResponse.setResultDesc(Response.FAILURE.getDesc());
		return twistWalletResponse;
	}

}
