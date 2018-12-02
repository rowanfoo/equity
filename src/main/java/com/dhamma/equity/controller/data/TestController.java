package com.dhamma.equity.controller.data;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {


    @RequestMapping("/test")
    @CrossOrigin
    public void test(@RequestBody TestData dt){

        System.out.println("--------------------------------------TEST DT-----------------"+ dt);
    }



    @RequestMapping("/getdata")
    @CrossOrigin
    public ArrayList<TestData > getdata(){

        System.out.println("--------------------------------------getdata DT-----------------");
        ArrayList<TestData > arr = new ArrayList<>();
        arr.add(new TestData ("ROWAN " ," FREEDOME "));
        arr.add(new TestData ("GARY " ," HAPPY "));
        arr.add(new TestData ("KAIKAI " ," ADVENTURE "));

        return arr;
    }




}
