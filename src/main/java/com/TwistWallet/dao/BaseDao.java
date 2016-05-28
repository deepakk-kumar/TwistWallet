package com.TwistWallet.dao;

import java.util.List;
import java.util.Map;

import com.TwistWallet.Entity.UserEntity;

public interface BaseDao<BaseDomain> {

	public BaseDomain save(BaseDomain domain);
	public BaseDomain find(BaseDomain domain);
	public void update(BaseDomain domain);
	public BaseDomain findWithNamedQueries(String namedQuery,Class<? extends BaseDomain> domain ,Map<String, ?> params);
	public List<? extends BaseDomain> findWithNamedQuery(String namedQuery,  Class<? extends BaseDomain> domain,Map<String, ?> params);

}
