package com.adagency.online.model.sourcetype;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "oaa_films", catalog = "oaadb")
@TableGenerator(name = "films_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "films_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "films_id")
public class Films {
	@Id
	@GeneratedValue(generator = "films_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "film_id")
	private int filmId;
	
	@Column(name = "film_name")
	private String filmName;
	@Column(name = "director_name")
	private String directorName;
	@Column(name = "music_director")
	private String musicDirector;
	@Column(name = "producer")
	private String producer;
	@Column(name = "hero_name")
	private String heroName;
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Date releaseDate;

	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ad_id")
	private AdDetails addetails;*/
	
	
	
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	

}
