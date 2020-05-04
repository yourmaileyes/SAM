package com.sam.biz;

import com.sam.entity.Activity;
import com.sam.entity.Comment;

import java.util.List;

public interface MainBiz {
    Object longin(String username,String password,String type);
    List<Activity> activities();
    Activity activity(int id);
    List<Comment> getComments(int activityId);
    boolean isSelect(int studentId,int activityId);
    void insertComment(Comment comment);
    void insertSign(int userid,int activityid);
    void deleteSign(int userid,int activityid);
}
