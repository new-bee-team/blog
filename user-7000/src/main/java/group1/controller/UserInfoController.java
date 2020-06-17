package group1.controller;

import group1.service.impl.UserInfoServiceImpl;
import group2.annotation.NotNull;
import group2.returnJson.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * @author: KongKongBaby
 * @create: 2020-06-16 13:00
 * @description: 用户信息服务
 **/

@RestController
@RequestMapping("/user/info")
@Api(tags = "用户信息服务")
public class UserInfoController {

    @Resource
    private UserInfoServiceImpl userInfoService;

    @NotNull
    @PostMapping("/login/{pass}/{command}/{type}/{codeKey}")
    @ApiOperation(value = "用户登录,如果非验证码登录,codeKey为0000", notes = "当type=1时,pass,command对应账号密码,type=2时,对应邮箱;type=3对应手机,type=4对应微信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pass", value = "通行证", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "command", value = "口令", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "type", value = "认证类型", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "codeKey", value = "验证码的键", required = true, dataType = "String", paramType = "path")
    })
    public Result userLogin(@PathVariable String pass, @PathVariable String command,@PathVariable Integer type,@PathVariable String codeKey){
        return userInfoService.userLogin(pass,command,type,codeKey);
    }
}
