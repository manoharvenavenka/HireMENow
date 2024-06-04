package com.example.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity(name = "vacancy")
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vacancyId")
	private int vacancyId;

	@ManyToOne
	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
	private Company company;

	@Column(name = "postDate")
	@CreationTimestamp
	private Date postDate;

	@Column(name = "jobTitle")
	private String jobTitle;

	@Column(name = "description")
	private String description;

	@Column(name = "requirements")
	private String requirements;

	@Column(name = "noOfVacancies")
	private int noOfVacancies;

	@Temporal(TemporalType.DATE)
	@Column(name = "openDate")
	private String openDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "closeDate")
	private String closeDate;

}
