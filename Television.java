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
@Table(name = "oaa_television", catalog = "oaadb")
@TableGenerator(name = "television_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "television_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "television_id")
public class Television {

	@Id
	@GeneratedValue(generator = "television_tab_gen", strategy = GenerationType.TABLE)
	@Column(name="television_id")
	private int telId;
	
	@Column(name="Channelname")
	private String channelName;
	
	@Column(name="Fromdate")
	private String fromDate;
	
	@Column(name="Todate")
	private String toDate;
	@Column(name="Duration")
	private String duration;
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
	
	
	public int getTelId() {
		return telId;
	}
	public void setTelId(int telId) {
		this.telId = telId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	


	
}
