package com.dhamma.equity.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Daily {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private java.sql.Date date;
  private String code;
  private String comment;
  private String seen;
  private String yes;


}
