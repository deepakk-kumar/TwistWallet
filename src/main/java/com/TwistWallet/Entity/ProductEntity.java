package com.TwistWallet.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
@NamedQueries({
@NamedQuery(name="product.findAll",query="select p from ProductEntity p"),
@NamedQuery(name="product.findByProductId",query="select p from ProductEntity p where p.productId=:productId")
})
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")
	private int productId;
	
	@Column(name="productName")
	@Basic(optional = false)
	private String productName;
	
	@Column(name="productDetail")
	private String productDetail;
	
	@Column(name="productQuantity")
	@Basic(optional = false)
	private int productQuantity;
	
	@Column(name="price")
	@Basic(optional = false)
	private float price;
	
	@Column(name="productCode")
	private String productCode;

	@OneToOne
	@JoinColumn(name="sellerId")
	private SellerEntity seller;
			
	public SellerEntity getSeller() {
		return seller;
	}

	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString(){
		return ("id "+productId +"productName "+productName +"productQuantity "+productQuantity
				+"price "+price +"productCode "+productCode);
		
	}
}
