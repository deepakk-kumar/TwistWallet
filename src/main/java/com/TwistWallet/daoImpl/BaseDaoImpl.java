package com.TwistWallet.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.TwistWallet.dao.BaseDao;

public class BaseDaoImpl<BaseDomain> implements BaseDao<BaseDomain> {

	@PersistenceContext
	EntityManager manager;
	
	private Class<BaseDomain> type;
	
	 public BaseDaoImpl() {
	        Type t = getClass().getGenericSuperclass();
	        ParameterizedType pt = (ParameterizedType) t;
	        type = (Class) pt.getActualTypeArguments()[0];
	    }
	 
	@Override
	@Transactional
	public BaseDomain save(BaseDomain doamin) {
		manager.persist(doamin);
		return doamin;
	}

	@Override
	public BaseDomain find(BaseDomain domain) {
		manager.find(type, domain);
		return null;
	}

	@Override
	public List<? extends BaseDomain> findWithNamedQuery(String namedQuery, Class<? extends BaseDomain> domain,
			Map<String, ?> params) {
		TypedQuery<? extends BaseDomain> query = (TypedQuery<? extends BaseDomain>) manager
				.createNamedQuery(namedQuery, domain);
		if(params != null)
		{
			for(String each: params.keySet())
			{
				query.setParameter(each, (Object)params.get(each));
			}
		}
		List<? extends BaseDomain> list = query.getResultList();
		return list;
	}

}
