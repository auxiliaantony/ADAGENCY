package com.adagency.online.model.sourcetype;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.adagency.online.model.info.AdDetails;

@Entity

@Table(name = "oaa_product", catalog = "oaadb")
@TableGenerator(name = "product_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "oaa_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "product_id")
public class Product {
	@Id
	@GeneratedValue(generator = "product_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	@Column(name = "price")
	private String price;
	@Column(name = "Offer")
	private String offer;
	@Column(name = "warranty")
	private String warranty;
	@Column(name = "features")
	private String features;

	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ad_id")
	private AdDetails addetails;*/
	
	
	
	
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	
}
