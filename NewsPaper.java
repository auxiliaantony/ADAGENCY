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
@Table(name = "oaa_newspaper", catalog = "oaadb")
@TableGenerator(name = "newspaper_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "newspaper_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "newspaper_id")
public class NewsPaper {
	@Id
	@GeneratedValue(generator = "newspaper_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "newspaper_id")
	private int newsId;
	@Column(name = "newspaper_name")
	private String newspaperName;
	
	@Column(name = "from_date")
	private String fromDate;
	
	@Column(name = "to_date")
	private String toDate;
	@Column(name = "ad_size")
	private String adSize;
	@Column(name = "page_no")
	private String pageNo;

	
	@Column(name = "source_type", length = 10)
	@Enumerated(EnumType.STRING)
	private SourceType sourceType;

	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ad_id")
	private AdDetails addetails;*/
	

	
	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewspaperName() {
		return newspaperName;
	}

	public void setNewspaperName(String newspaperName) {
		this.newspaperName = newspaperName;
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

	public String getAdSize() {
		return adSize;
	}

	public void setAdSize(String adSize) {
		this.adSize = adSize;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	

}
