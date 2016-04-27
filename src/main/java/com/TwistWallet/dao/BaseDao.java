package com.TwistWallet.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<BaseDomain> {

	public BaseDomain save(BaseDomain domain);
	public BaseDomain find(BaseDomain domain);
	public List<? extends BaseDomain> findWithNamedQuery(String namedQuery,  Class<? extends BaseDomain> domain,Map<String, ?> params);
	
}
