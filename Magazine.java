package com.adagency.online.model.adtype;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.SourceType;

@Entity

@Table(name = "oaa_magazine", catalog = "oaadb")
@TableGenerator(name = "magazine_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "magazine_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "magazine_id")
public class Magazine {
	
	@Id
	@GeneratedValue(generator = "magazine_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "magazine_id")
	private int magId;
	
	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	@Column(name = "source_type", length = 10)
	@Enumerated(EnumType.STRING)
	private SourceType sourceType;
	

	@Column(name = "magazine_name")
	private String magName;
	
	
	@Column(name = "from_date")
	private String fromDate;
	
	
	@Column(name = "to_date")
	private String toDate;
	
	@Column(name = "magazine_size")
	private String magSize;
	@Column(name = "page_no")
	private String pageNo;

	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ad_id")
	private AdDetails addetails;*/
	

	

	

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

	public String getMagName() {
		return magName;
	}

	public void setMagName(String magName) {
		this.magName = magName;
	}

	public int getMagId() {
		return magId;
	}

	public void setMagId(int magId) {
		this.magId = magId;
	}

	public String getMagSize() {
		return magSize;
	}

	public void setMagSize(String magSize) {
		this.magSize = magSize;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	
}
