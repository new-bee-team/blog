package group1.service;

import group2.returnJson.Result;

public interface IUserAccountService {

    Result getUserAccountById(Integer id);

    // 注册用户
    Result saveUserAccount(String account, String password);
}
