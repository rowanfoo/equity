package com.dhamma.equity.controller.data;

import lombok.Data;

@Data
public class TestData {

    String name ;
    String code ;

    public TestData (String name, String code){
        this.name=name;
        this.code=code;
    }

//    @Override
//    public String toString() {
//        return "TestData{" +
//                "name='" + name + '\'' +
//                ", code='" + code + '\'' +
//                '}';
//    }
}
