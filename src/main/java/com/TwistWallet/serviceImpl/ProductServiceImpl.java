package com.TwistWallet.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TwistWallet.Entity.ProductEntity;
import com.TwistWallet.dao.BaseDao;
import com.TwistWallet.dto.Product;
import com.TwistWallet.dto.Seller;
import com.TwistWallet.service.ProductService;
import com.TwistWallet.utils.Response;
import com.TwistWallet.utils.TwistWalletResponse;

@Service
public class ProductServiceImpl implements ProductService{

@Autowired
BaseDao baseDaoImpl;
	
	@Override
	public TwistWalletResponse getAllProducts() {
		TwistWalletResponse response = new TwistWalletResponse();
		Map<String,Object> map = new HashMap<>();
		//map.put("", value)
		List<ProductEntity> productEntity = (List<ProductEntity>) baseDaoImpl.findWithNamedQuery("product.findAll", ProductEntity.class, map);
		
		if(productEntity != null && productEntity.size() > 0){
			List<Product> productList = new ArrayList<Product>();
			for(ProductEntity eachEntity:productEntity){
			Product product = new Product();
			populateProductDTO(product,eachEntity);
			productList.add(product);
			//}
			response.setProduct(productList);
			response.setResultCode(Response.SUCCESS.getResultCode());
			response.setResultDesc(Response.SUCCESS.getDesc());
			return response;
		}
		response.setResultCode(Response.FAILURE.getResultCode());
		response.setResultDesc(Response.FAILURE.getDesc());
		return response;
	}

	private void populateProductDTO(Product product, ProductEntity eachEntity) {
		// TODO Auto-generated method stub
		Seller seller = new Seller();
		seller.setSellerId(eachEntity.getSeller().getSellerId());
		seller.setSellerName(eachEntity.getSeller().getSellerName());
		product.setSeller(seller);
		product.setProductId(eachEntity.getProductId());
		product.setProductCode(eachEntity.getProductCode());
		product.setProductName(eachEntity.getProductName());
		product.setProductDetail(eachEntity.getProductDetail());
		product.setPrice(eachEntity.getPrice());
		product.setProductQuantity(eachEntity.getProductQuantity());
	}

}
