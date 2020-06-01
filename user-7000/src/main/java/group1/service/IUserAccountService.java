package group1.service;

import group2.returnJson.Result;

public interface IUserAccountService {

    Result getUserAccountById(Integer id);

    // 注册用户
    Result saveUserAccount(String account, String password);

    // 测试1
    Object test1(Object obj);

    // 测试2
    Object test2(Object obj);
}
