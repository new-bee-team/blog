package group7.controler;

import group2.enums.Result;
import group2.enums.Status;
import group7.file.FastDFSClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@Api(tags = "静态文件(图片)上传")
public class FileController {

    @Resource
    private FastDFSClient fileDfs;

    @Value("${fdfs.web-server-url}")
    private String header;

    //文件上传
    @ApiOperation(value = "静态文件(图片)上传")
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public Result upload(@ApiParam(value = "file", required = true) MultipartFile file) {
        try {
            String path = header + fileDfs.upload(file);
            if (StringUtils.isEmpty(path))
                return Result.fail(Status.BAD_REQUEST,"文件路径为空");
            else {
                return Result.success(path);
            }
        } catch (FileNotFoundException e) {
            return Result.fail(Status.NOT_FOUND, "文件未找到");
        } catch (IOException e) {
            return Result.fail(Status.INTERNAL_SERVER_ERROR, "文件IO异常");
        } catch (Exception e) {
            return Result.fail(Status.INTERNAL_SERVER_ERROR);
        }
    }
}