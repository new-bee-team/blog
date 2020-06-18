package group7.controller;

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
@Api(tags = "文件服务")
public class FileController {

    @Resource
    private IFileService fileService;

    @ApiOperation(value = "图片上传",notes = "返回图片地址")
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public String upload(@ApiParam(value = "file", required = true) MultipartFile file) {
        return fileService.upload(file);
    }
}