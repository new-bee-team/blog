package group7.service.impl;

import group7.file.FastDFSClient;
import group7.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:46
 * @description:
 **/

@Service
@Slf4j
public class FileServiceImpl implements IFileService {

    @Resource
    private FastDFSClient fileDfs;

    @Value("${fdfs.web-server-url}")
    private String header;

    @Override
    @Async
    public String upload(MultipartFile file) {
        try {
            String path = header + fileDfs.upload(file);
            if (StringUtils.isEmpty(path))
                throw new RuntimeException("文件路径不存在");
            else {
                return path;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
