package com.mattmottle.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")

public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min= 3, max= 200, message="Name must be at least 3 characters.")
	private String name;
	
	@NotNull
	@Size(min=3, max=200, message="Restaurant name must be at least 3 characters.")
	private String restaurant;
	
	@NotNull
	@Min(value=1, message="Rating must be higher than 0.")
	@Max(value=5, message="Rating must be 5 or less.")
	private Integer rating;
	
	@NotNull
	@Size(min=4, max= 200, message="Notes must be more than 4 characters.")
	private String notes;
	
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	    
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	 public Burger() {
	 }
	 
	 public Burger(String name, String restaurant, Integer rating, String notes) {
		 this.name = name;
		 this.restaurant = restaurant;
		 this.rating = rating;
		 this.notes = notes;
	 }
	 
	 @PrePersist
	 protected void onCreate(){
		 this.createdAt = new Date();
	    }
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
}
