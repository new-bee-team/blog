package group7.controler;

import group7.code.service.impl.CodeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 10:55
 * @description: 验证码
 **/

@RestController
@RequestMapping("/code")
@Api(tags = "图片验证码服务")
public class CodeController {

    @Resource
    private CodeServiceImpl codeService;

    @PostMapping("/get")
    @ApiOperation(value = "获取图片验证码", notes = "无参，直接返回图片")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        codeService.getImgCode(request,response);
    }

    @PostMapping("/check/{code}")
    @ApiOperation(value = "验证验证码", notes = "true/false表示是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String", paramType = "path")
    })
    public Boolean checkCode(@PathVariable String code, HttpServletRequest request){
        return codeService.checkCode(code,request);
    }
}
