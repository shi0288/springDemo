package com.mcp.myself.service;


import org.springframework.stereotype.Component;

@Component
public class PersonServiceBean implements PersonServer {

    @Override
    public String save(String name) {

        System.out.println("save");
        return "111111";
        //	throw new RuntimeException();
    }

    @Override
    public void update(String name, Integer id) {

        System.out.println("update()");
    }

    @Override
    public String getPersonName(Integer id) {
        System.out.println("getPersonName()");
        return "xxx";
    }

    @Override
    public String  tip(String name) {
        System.out.println("tip");
        //	throw new RuntimeException();
        return "22222222";
    }

}
