package com.dhamma.equity.data.repo;

import com.dhamma.equity.data.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface DailyRepo extends JpaRepository<Daily,Long> {

}
