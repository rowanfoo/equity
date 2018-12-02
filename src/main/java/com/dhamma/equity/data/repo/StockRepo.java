package com.dhamma.equity.data.repo;

import com.dhamma.equity.data.entity.CoreStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface StockRepo extends JpaRepository<CoreStock,Long>, QuerydslPredicateExecutor<CoreStock> {


}
