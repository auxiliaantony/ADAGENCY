package com.adagency.online.model.info;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.adagency.online.model.UserProfile1;
import com.adagency.online.model.adtype.Magazine;

@Entity
@Table(name = "oaa_addetails", catalog = "oaadb")

@TableGenerator(name = "addetails_tab_gen", allocationSize = 1, initialValue = 1, catalog = "oaadb", table = "addetails_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ad_id")
public class AdDetails {
	
	@Id
	@GeneratedValue(generator = "addetails_tab_gen", strategy =
	 GenerationType.TABLE)
	@Column(name = "ad_id")
	private int adId;
	
	/*@Column(name = "source_type0", length = 10)
	@Enumerated(EnumType.STRING)
	private SourceType sourceType;*/

	@Column(name = "ad_type", length = 50)
	@Enumerated(EnumType.STRING)
	private AdType adType;

	@Column(name = "budjet", length = 50)
	@Enumerated(EnumType.STRING)
	private Budjet budjet;

	public Budjet getBudjet() {
		return budjet;
	}

	public void setBudjet(Budjet budjet) {
		this.budjet = budjet;
	}

	public AdType getAdType() {
		return adType;
	}

	public void setAdType(AdType adType) {
		this.adType = adType;
	}

	


	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	
}
