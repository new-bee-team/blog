package group7.service.serviceImpl;

import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import group7.file.FastDFSClient;
import group7.service.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:46
 * @description:
 **/

@Service
public class FileServiceImpl implements IFileService {

    @Resource
    private FastDFSClient fileDfs;

    @Value("${fdfs.web-server-url}")
    private String header;

    @Override
    public Result upload(MultipartFile file) {
        try {
            String path = header + fileDfs.upload(file);
            if (StringUtils.isEmpty(path))
                return Result.fail(StatusEnum.BAD_REQUEST,"文件路径为空");
            else {
                return Result.success(path);
            }
        } catch (FileNotFoundException e) {
            return Result.fail(StatusEnum.NOT_FOUND, "文件未找到");
        } catch (IOException e) {
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR, "文件IO异常");
        } catch (Exception e) {
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
        }
    }
}
