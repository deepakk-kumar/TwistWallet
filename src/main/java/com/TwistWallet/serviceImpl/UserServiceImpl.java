package com.TwistWallet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.TwistWallet.Entity.LoginEntity;
import com.TwistWallet.Entity.UserEntity;
import com.TwistWallet.dao.BaseDao;
import com.TwistWallet.dto.Login;
import com.TwistWallet.dto.User;
import com.TwistWallet.service.UserService;
import com.TwistWallet.utils.Response;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;
import com.TwistWallet.utils.TwistWalletUtils;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	BaseDao baseDaoImpl;
	
	@Override
	public TwistWalletResponse createUser(TwistWalletRequest request) {
		UserEntity userEntity = new UserEntity();
		LoginEntity loginEntity = new LoginEntity();
		userEntity.setEmailAddress(request.getUser().getEmailAddress());
		userEntity.setFirstName(request.getUser().getFirstName());
		userEntity.setLastName(request.getUser().getLastName());
		userEntity.setMobileNumber(request.getUser().getMobileNumber());
		userEntity.setNewUser(true);
		//userEntity.setPassword(request.getUser().getPassword());
		userEntity.setAdmin(request.getUser().isAdmin());
		String genPassword = TwistWalletUtils.getPassword(request.getUser().getEmailAddress());
		userEntity = (UserEntity) baseDaoImpl.save(userEntity);
		
		loginEntity.setPassword(genPassword);
		Login login = new Login();
		login.setPassword(genPassword);
		request.setLogin(login);
		
		loginEntity.setUser(userEntity);
		loginEntity = (LoginEntity) baseDaoImpl.save(loginEntity);
		TwistWalletResponse response = new TwistWalletResponse();
		
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setEmailAddress(userEntity.getEmailAddress());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setAdmin(userEntity.getAdmin());
		//user.setNewUser(userEntity.getNewUser());
		response.setUser(user);
		sendMail(request);
		response.setResultCode(Response.SUCCESS.getResultCode());
		response.setResultDesc(Response.SUCCESS.getDesc());
		return response;
	}
	
	@Override
	public TwistWalletResponse sendMail(TwistWalletRequest request) {
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(request.getUser().getEmailAddress());
        email.setSubject("Twist-wallet");
        email.setText("welcome to twist-wallet. You have sucessfully registered with TwistWallet. Your password is :- "+request.getLogin().getPassword());
        email.setFrom("No-reply");
        // sends the e-mail
        mailSender.send(email);
		return null;
	}
}
