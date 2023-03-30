package ru.loonolud.potterfox.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.loonolud.potterfox.dto.response.FileInfoResponse;

public interface IconInfoService {

    FileInfoResponse saveFile(MultipartFile file);

    FileInfoResponse getFileInfo(String id);

    ResponseEntity<Resource> getFileContent(String id);

}
