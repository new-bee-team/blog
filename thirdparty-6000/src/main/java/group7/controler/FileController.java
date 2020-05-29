package group7.controler;

import group7.service.IFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
@Api(tags = "静态文件上传")
public class FileController {

    @Resource
    private IFileService fileService;

    //文件上传
    @ApiOperation(value = "静态文件(图片)上传")
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public String upload(@ApiParam(value = "file", required = true) MultipartFile file) {
        return fileService.upload(file);
    }
}