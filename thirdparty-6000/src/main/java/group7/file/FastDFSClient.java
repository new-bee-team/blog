package group7.file;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author: KongKongBaby
 * @Date: 2020.03.02 15:58
 * @Description:
 */
@Component
public class FastDFSClient {
    @Resource
    private FastFileStorageClient storageClient;

    //上传文件
    public String upload(MultipartFile multipartFile) throws Exception {
        String originalFilename = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(multipartFile.getInputStream(), multipartFile.getSize(), originalFilename, null);
        return storePath.getFullPath();
    }
}
