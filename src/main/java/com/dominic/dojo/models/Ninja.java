package com.dominic.dojo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
  
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String first;
  private String last; 
  private Integer age;

        //? This will not allow the createdAt column to be updated after creation
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date createdAt;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date updatedAt;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name= "dojo_id")
        private Dojo dojo;


  public Ninja() {
  }


  public Ninja(Long id, String first, String last, Integer age, Date createdAt, Date updatedAt, Dojo dojo) {
    this.id = id;
    this.first = first;
    this.last = last;
    this.age = age;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.dojo = dojo;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }
  

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.first;
  }

  public void setFirstName(String first) {
    this.first = first;
  }

  public String getLastName() {
    return this.last;
  }

  public void setLastName(String last) {
    this.last = last;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Dojo getDojo() {
    return this.dojo;
  }

  public void setDojo(Dojo dojo) {
    this.dojo = dojo;
  }



}
