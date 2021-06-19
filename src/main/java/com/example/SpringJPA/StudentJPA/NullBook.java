package com.example.SpringJPA.StudentJPA;

import java.util.Optional;

public class NullBook   {

    Optional<String> bookName;
    public NullBook(Optional<String> name){
        bookName= name;
    }
    public Optional<String> getName(){
        return bookName;
    }
}
