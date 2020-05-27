package group7.service;

import group2.returnJson.Result;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    Result upload(MultipartFile file);
}
