package com.demo.mapper;

import com.demo.domain.LoginLog;

/**
 * Created by Administrator on 2016/12/4.
 */
public interface LoginLogMapper {
    void updateLog(int id,int isDelete);
    void addLog(LoginLog loginLog);
    LoginLog getLogById(int id);
}
