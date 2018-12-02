package com.dhamma.equity.controller.data;

import com.dhamma.equity.data.entity.CoreData;
import com.dhamma.equity.service.data.CoreDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CoreDataController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CoreDataService coreDataService;

///get all ? code , data_when
    @RequestMapping()
    //@CrossOrigin(origins = "http://localhost:8090")
    @CrossOrigin
    public Iterable<CoreData> getDataFrom(@RequestParam String code, @RequestParam String date ){
        return coreDataService.getDataFrom(code,date );
    }



    @CrossOrigin
    @RequestMapping("/stocks")
    public Iterable<CoreData> getDataStockDate(@RequestParam String stocks, @RequestParam String date ){

        System.out.println("--------------getDataStockDate ------------" + stocks);

        String arr[] = stocks.split(",");


        return coreDataService.getDataAllStock(arr,date );
    }




    @CrossOrigin
    @RequestMapping("/clearcache")
    public String  clearCache(){
        coreDataService.clearcache();
        return "done";
    }






}
