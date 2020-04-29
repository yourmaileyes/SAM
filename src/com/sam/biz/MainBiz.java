package com.sam.biz;

import com.sam.entity.Activity;

import java.util.List;

public interface MainBiz {
    Object longin(String username,String password,int type);
    List<Activity> activities();
}
