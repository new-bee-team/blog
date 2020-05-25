package group1.controller;

import group1.dao.GetUserAccountDao;
import group1.service.serviceImpl.GetUserAccountServiceImpl;
import group2.entity.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:28
 * @description:
 **/

@RestController
@RequestMapping("/user/get")
public class GetUserAccountController {

    @Autowired
    private GetUserAccountServiceImpl getUserAccountService;

    @GetMapping("/id/{id}")
    public UserAccount getUserAccountById(@PathVariable Integer id){
        return getUserAccountService.getUserAccountById(id);
    }
}
