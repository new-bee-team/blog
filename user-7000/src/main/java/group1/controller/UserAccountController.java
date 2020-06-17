package group1.controller;

import group1.service.impl.UserAccountServiceImpl;
import group2.annotation.NotNull;
import group2.entity.vo.UserAccountVO;
import group2.returnJson.Result;
import group2.util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:28
 * @description:
 **/

@RestController
@RequestMapping("/user/account")
@Api(tags = "用户账户服务")
public class UserAccountController {


    @Autowired
    private UserAccountServiceImpl userAccountService;

    @NotNull
    @GetMapping("/id/{id}")
    @ApiOperation(value = "根据id查询用户账号信息", notes = "成功返回200，失败返回500、611或其他")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int", paramType = "path")
    })
    public Result getUserAccountById(@PathVariable Integer id) {
        return userAccountService.getUserAccountById(id);
    }

    @NotNull
    @ApiOperation(value = "用户注册，只需要账号密码", notes = "帐号最大10位，密码最大18位；帐号不可修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户帐号", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "path")
    })
    @PostMapping("/{account}/{password}")
    public Result saveUserAccount(@PathVariable String account, @PathVariable String password) {
        return userAccountService.saveUserAccount(account, password);
    }

    @PostMapping("/codeKey")
    @ApiOperation(value = "用户点击获取验证码调用的接口，返回该code的键k，无参")
    public Result setUpdateAccountCodeKey() {
        String k = CodeUtil.setCode();
        return Result.success(k);
    }

    @NotNull
    @ApiOperation(value = "绑定邮箱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "email", value = "用户邮箱", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "code", value = "用户验证码", required = true, dataType = "String", paramType = "path")
    })
    @PostMapping("/{userId}/{email}/{code}")
    public Result bindEmail(@PathVariable Integer userId, @PathVariable String email, @PathVariable String code) {
        return userAccountService.bindEmail(userId, email, code);
    }
}
