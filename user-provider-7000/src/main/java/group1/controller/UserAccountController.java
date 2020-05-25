package group1.controller;

import group1.service.serviceImpl.UserAccountServiceImpl;
import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:28
 * @description:
 **/

@RestController
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @GetMapping("/id/{id}")
    public UserAccountDO getUserAccountById(@PathVariable Integer id){
        return userAccountService.getUserAccountById(id);
    }

    @PostMapping("/account")
    public Integer saveUserAccount(@RequestBody UserAccountVO userAccount){
        return userAccountService.saveUserAccount(userAccount);
    }
}
