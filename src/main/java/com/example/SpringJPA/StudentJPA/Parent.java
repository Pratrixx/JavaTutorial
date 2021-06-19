package com.example.SpringJPA.StudentJPA;

import java.util.List;
import java.util.Optional;

public class Parent {

    void say (List<String> list){
        System.out.println("parent");
    }

    Optional<String> bookName;
    public Parent(Optional<String> name){
        bookName = name;


    }
    public Optional<String> getName(){
        return  bookName;
    }

}
