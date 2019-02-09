package com.adagency.online.model.adtype;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.SourceType;

@Entity
@Table(name = "oaa_internet", catalog = "oaadb")
@TableGenerator(name = "internet_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "internet_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "internet_id")
public class Internet {
	@Id
	@GeneratedValue(generator = "internet_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "internet_id")
	private int netId;

	@Column(name = "source_type", length = 10)
	@Enumerated(EnumType.STRING)
	private SourceType sourceType;


	@Column(name = "website_name")
	private String websiteName;
	
	@Column(name = "from_date")
	private String fromDate;

	
	@Column(name = "to_date")
	private String toDate;
	@Column(name = "display_size")
	private String size;
	@Column(name = "media")
	private String media;

	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ad_id")
	private AdDetails addetails;*/

	

	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	public int getNetId() {
		return netId;
	}

	public void setNetId(int netId) {
		this.netId = netId;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}


	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

}
