package com.mcp.myself.service;

/**
 * Created by Administrator on 2015/12/15 0015.
 */
public interface PersonServer {

    public String save(String name);
    public void update(String name, Integer id);
    public String getPersonName(Integer id);
    public String tip(String name);

}
