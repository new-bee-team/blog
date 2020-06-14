package group7.controler;

import group2.annotation.NotNull;
import group2.util.CodeUtil;
import group7.code.service.impl.CodeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 10:55
 * @description: 验证码
 **/

@RestController
@RequestMapping("/code")
@Api(tags = "验证码服务")
public class CodeController {

    @Resource
    private CodeServiceImpl codeService;

    @NotNull
    @PostMapping("/img/get")
    @ApiOperation(value = "获取图片验证码", notes = "无参，直接返回图片")
    public void getImgCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        codeService.getImgCode(request, response);
    }

    @NotNull
    @PostMapping("/img/check/{code}")
    @ApiOperation(value = "验证图片验证码", notes = "true/false表示是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String", paramType = "path")
    })
    public Boolean checkImgCode(@PathVariable String code, HttpServletRequest request) {
        return codeService.checkImgCode(code, request);
    }

    @NotNull
    @PostMapping("/string/get/{k}")
    @ApiOperation(value = "普通字符串验证码", notes = "查询不到返回null")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "k", value = "验证码的key", required = true, dataType = "String", paramType = "path")
    })
    public String getStringCode(@PathVariable String k) {
        return codeService.getStringCode(k);
    }

    @NotNull
    @PostMapping("/string/check/{k}/{v}")
    @ApiOperation(value = "普通字符串验证", notes = "true/false表示是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "k", value = "验证码的key", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "v", value = "验证码的value", required = true, dataType = "String", paramType = "path")
    })
    public Boolean checkStringCode(@PathVariable String k, @PathVariable String v) {
        return codeService.checkStringCode(k, v);
    }

    @Async
    @PostMapping({"/string/set","/string/set/{time}/{timeUnit}"})
    @ApiOperation(value = "生成字符串验证码并返回对应的key")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "验证码保存在缓存中的时间,类似是Long", required = false, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "timeUnit", value = "时间单位,类型是TimeUint", required = false, dataType = "TimeUnit", paramType = "path")
    })
    public String setCode(@PathVariable(required = false) Long time,@PathVariable(required = false) TimeUnit timeUnit) {
        String k = CodeUtil.setCode(time,timeUnit);
        return k;
    }
}
