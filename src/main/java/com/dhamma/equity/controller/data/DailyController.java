package com.dhamma.equity.controller.data;

import com.dhamma.equity.data.entity.Daily;
import com.dhamma.equity.data.repo.DailyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daily")
public class DailyController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DailyRepo dailyRepo;

    ///get all ? code , data_when
    @PutMapping()
    @CrossOrigin
    public void  insert (Daily daily){

        dailyRepo.saveAndFlush(daily);


    }






}
