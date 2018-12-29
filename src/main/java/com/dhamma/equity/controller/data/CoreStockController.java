package com.dhamma.equity.controller.data;



import com.dhamma.equity.data.entity.CoreData;
import com.dhamma.equity.data.entity.CoreStock;
import com.dhamma.equity.data.entity.QCoreStock;
import com.dhamma.equity.data.repo.StockRepo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/stock")
@Log
public class CoreStockController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    StockRepo stockRepo;

    ///get all ? code , data_when
    @GetMapping("/wishlist")
    @CrossOrigin
    @ApiOperation(value = "Get all WISHLIST for today ",  notes = "Get all WISHLIST for today")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = CoreStock[].class ),
    })

    public Iterable<CoreStock> wishlist(){
        return stockRepo.findAll(QCoreStock.coreStock.wishlist.eq("Y"));

    }



    @PostMapping("/fundemental")
    public void  fundemental(@RequestParam String code, @RequestParam Optional<String> description , @RequestParam Optional<String> reason , @RequestParam Optional<String> tag ,
                             @RequestParam Optional<String> tolook ){
        System.out.println("---------fundemental-------" + code);
        System.out.println("---------fundemental-------" + description);
        System.out.println("---------fundemental-------" + reason);
        System.out.println("---------fundemental-------" + tag);
        System.out.println("---------fundemental-------" + tolook);
        System.out.println("---------fundemental-------" + tolook.isPresent());



        CoreStock core =  stockRepo.findOne(QCoreStock.coreStock.code.eq(code)).get() ;
        core.setDescp(description.get());
        core.setReason(reason.get());
        core.setTags(tag.get());
        core.setTolook(tolook.isPresent()?"Y":"N" );
        stockRepo.save(core);

    }







    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "Get all stocks  ",  notes = "Get all stocks from table")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = CoreStock[].class  ),
    })
    public Iterable<CoreStock> getall(){
        System.out.println("---------getall-------" );
        return stockRepo.findAll();

    }



        ///get all ? code , data_when
    @GetMapping("/{code}")
    @CrossOrigin
    public CoreStock getstock(@PathVariable String code){
        return stockRepo.findOne(QCoreStock.coreStock.code.eq(code)).get();

    }







}
