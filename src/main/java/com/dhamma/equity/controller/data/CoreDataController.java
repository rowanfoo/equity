package com.dhamma.equity.controller.data;

import com.dhamma.equity.data.entity.CoreData;
import com.dhamma.equity.data.entity.CoreStock;
import com.dhamma.equity.service.data.CoreDataService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class CoreDataController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CoreDataService coreDataService;

///get all ? code , data_when
    @GetMapping("")
    //@CrossOrigin(origins = "http://localhost:8090")
    @CrossOrigin

    @ApiOperation(value = "Get Data for date",  notes = "Get stock data (price and etc) for a date")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = CoreData[].class),
    })
    public Iterable<CoreData> getDataFrom(@RequestParam String code, @RequestParam String date ){
        return coreDataService.getDataFrom(code,date );
    }



    @CrossOrigin
    @GetMapping("/stocks")
    @ApiOperation(value = "Get  all stockS , price data base on DATE ",  notes = "Get  all stockS separate by \",\"  for its price data ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = CoreData[].class),
    })
    public Iterable<CoreData> getDataStockDate(@ApiParam(required = true, name = "stocks", value = "comma separated stock code")@RequestParam String stocks, @RequestParam String date ){

        System.out.println("--------------getDataStockDate ------------" + stocks);

        String arr[] = stocks.split(",");


        return coreDataService.getDataAllStock(arr,date );
    }




    @CrossOrigin
    @GetMapping("/clearcache")
    public String  clearCache(){
        coreDataService.clearcache();
        return "done";
    }






}
