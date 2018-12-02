package com.dhamma.equity;

import com.dhamma.equity.controller.data.CoreDataController;
import com.dhamma.equity.data.entity.CoreData;
import com.dhamma.equity.data.entity.QCoreData;
import com.dhamma.equity.data.entity.QCoreStock;
import com.dhamma.equity.data.repo.DataRepo;
import com.dhamma.equity.data.repo.StockRepo;
import com.dhamma.equity.service.data.CoreDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquityApplicationTests {
@Autowired
    CoreDataService coreDataService;
@Autowired
    CoreDataController coreDataController;
    @Test
    public void contextLoads() {
        System.out.println("-----------------GO 1");
        coreDataService.getDataFrom("bhp.ax" ,"2018-01-01");
        System.out.println("-----------------GO 2");

        coreDataService.getDataFrom("bhp.ax" ,"2018-01-01");

        System.out.println("-----------------GO 3");
        coreDataController.clearCache();
        coreDataService.getDataFrom("bhp.ax" ,"2018-01-01");
        System.out.println("-----------------GO 4");


    }
@Autowired
    DataRepo dataRepo;
    @Test
    public void testcoredatacaceh() {
        System.out.println("-----------------GO 1");
        Iterable<CoreData> data =  dataRepo.findAll(QCoreData.coreData.date.gt(LocalDate.parse("2018-11-16"))
                .and(QCoreData.coreData.code.eq("bhp.ax")));
        System.out.println("-----------------GO 2");
        data =  dataRepo.findAll(QCoreData.coreData.date.gt(LocalDate.parse("2018-11-16"))
                .and(QCoreData.coreData.code.eq("bhp.ax")));
        System.out.println("-----------------GO 3");

    }

    @Autowired StockRepo stockRepo;
    @Test
    public void testcorstockcaceh() {

        System.out.println("-----------------GO 1");
        long startTime = System.currentTimeMillis();
        stockRepo.findOne(QCoreStock.coreStock.code.eq("bhp.ax"));
        Long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("-----------------GO 2  " + estimatedTime);
        startTime = System.currentTimeMillis();
        stockRepo.findOne(QCoreStock.coreStock.code.eq("bhp.ax"));
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("-----------------GO 3  " + estimatedTime);
        System.out.println("-----------------GO 4");
        startTime = System.currentTimeMillis();
        stockRepo.findOne(QCoreStock.coreStock.code.eq("bhp.ax"));
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("-----------------GO 5  " + estimatedTime);




    }


}
