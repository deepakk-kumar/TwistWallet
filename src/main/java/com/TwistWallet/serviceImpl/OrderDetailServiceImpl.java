package com.TwistWallet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TwistWallet.Entity.OrderDetailsEntity;
import com.TwistWallet.Entity.SellerEntity;
import com.TwistWallet.Entity.UserEntity;
import com.TwistWallet.dao.BaseDao;
import com.TwistWallet.service.OrderDetailService;
import com.TwistWallet.utils.Response;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	BaseDao baseDaoImpl;
	
	@Override
	public TwistWalletResponse placeOrder(TwistWalletRequest request) {
		TwistWalletResponse response = new TwistWalletResponse();
		if(request.getOrderDetails().getUser() != null && 
				request.getOrderDetails().getUser().getEmailAddress() != null &&
			request.getOrderDetails().getSeller() != null )
		{
			UserEntity user = new UserEntity();
			user.setUserId(request.getOrderDetails().getUser().getUserId());
			user.setFirstName(request.getOrderDetails().getUser().getFirstName());
			user.setLastName(request.getOrderDetails().getUser().getLastName());
			user.setEmailAddress(request.getOrderDetails().getUser().getEmailAddress());
			user.setMobileNumber(request.getOrderDetails().getUser().getMobileNumber());
			user.setAddress(request.getOrderDetails().getUser().getAddress());
			user.setPostelCode(request.getOrderDetails().getUser().getPostelCode());
			baseDaoImpl.update(user);
			
			SellerEntity sellerEntity = new SellerEntity();
			sellerEntity.setSellerId(request.getOrderDetails().getSeller().getSellerId());
			
			OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
			orderDetailsEntity.setSeller(sellerEntity);
			orderDetailsEntity.setUser(user);
			orderDetailsEntity.setAmount(request.getOrderDetails().getAmount());
			orderDetailsEntity.setOrderStatus("Pending");
			orderDetailsEntity.setOrderDetails(request.getOrderDetails().getOrderInfo());
			baseDaoImpl.save(orderDetailsEntity);
			
			response.setResultCode(Response.SUCCESS.getResultCode());
			response.setResultDesc(Response.SUCCESS.getDesc());
			return response;
		}
		response.setResultCode(Response.FAILURE.getResultCode());
		response.setResultDesc(Response.FAILURE.getDesc());
		return response;
	}

}
