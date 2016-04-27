package com.TwistWallet.service;

import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

public interface UserService {
	public TwistWalletResponse createUser(TwistWalletRequest request);
}
