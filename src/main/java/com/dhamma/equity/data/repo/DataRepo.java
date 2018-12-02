package com.dhamma.equity.data.repo;

import com.dhamma.equity.data.entity.CoreData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo extends JpaRepository<CoreData,Long>, QuerydslPredicateExecutor<CoreData> {



}
