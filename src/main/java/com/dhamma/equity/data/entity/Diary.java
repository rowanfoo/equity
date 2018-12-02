package com.dhamma.equity.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Diary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private java.sql.Date date;
  private String codes;
  private String codeNotes;
  private String codesNo;
  private String bookNotes;
  private String bookNo;
  private String prayerMinute;
  private String fitnessMinute;
  private String notes;



}
