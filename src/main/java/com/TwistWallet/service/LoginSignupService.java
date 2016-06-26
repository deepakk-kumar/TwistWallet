package com.TwistWallet.service;

import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

public interface LoginSignupService {

	TwistWalletResponse login(TwistWalletRequest request);
	TwistWalletResponse reset(TwistWalletRequest request);
	TwistWalletResponse duplicateEmail(TwistWalletRequest request);
	TwistWalletResponse forgotPassword(TwistWalletRequest request);
}
