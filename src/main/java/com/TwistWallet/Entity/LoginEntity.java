package com.TwistWallet.Entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="login")
@NamedQueries({
	@NamedQuery(name="login.findByUserId",query="select u from LoginEntity u where u.user.userId=:uId"),
	@NamedQuery(name="login.findByLoginId",query="select l from LoginEntity l where l.loginId=:loginId")
})
public class LoginEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="loginId")
	private int loginId;
	
	@OneToOne
	@JoinColumn(name="userId")
	private UserEntity user;
	
	@Column(name="password")
	//@Cascade(CascadeType.MERGE)
	@Basic(optional = false)
	private String password;

	//@Column(name="Cart")
	/*@OneToMany(fetch = FetchType.EAGER, mappedBy="login")
	private List<CartEntity> cartEntity;
	
	
	public List<CartEntity> getCartEntity() {
		return cartEntity;
	}



	public void setCartEntity(List<CartEntity> cartEntity) {
		this.cartEntity = cartEntity;
	}
*/


	public int getLoginId() {
		return loginId;
	}



	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}



	public UserEntity getUser() {
		return user;
	}



	public void setUser(UserEntity user) {
		this.user = user;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	



	@Override
	public String toString(){
		return ("loginId "+loginId +"UserEntity "+user);
		
	}
}
