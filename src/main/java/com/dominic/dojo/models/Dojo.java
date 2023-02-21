package com.dominic.dojo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
  

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

      //? This will not allow the createdAt column to be updated after creation
      @Column(updatable=false)
      @DateTimeFormat(pattern="yyyy-MM-dd")
      private Date createdAt;
      @DateTimeFormat(pattern="yyyy-MM-dd")
      private Date updatedAt;
      @OneToMany(mappedBy="dojo", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
      private List<Ninja> ninja;


  public Dojo() {
  }


  public Dojo(Long id, String name, Date createdAt, Date updatedAt, List<Ninja> ninja) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.ninja = ninja;
  } 

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  } 

  public List<Ninja> getNinja() {
    return this.ninja;
  }

  public void setNinja(List<Ninja> ninja) {
    this.ninja = ninja;
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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

  // public List<Ninja> getNinjas() {
  //   return this.ninja;
  // }

  // public void setNinjas(List<Ninja> ninjas) {
  //   this.ninja = ninjas;
  // }

}
