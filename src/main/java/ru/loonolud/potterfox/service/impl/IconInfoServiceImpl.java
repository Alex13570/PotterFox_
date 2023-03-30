package ru.loonolud.potterfox.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.loonolud.potterfox.dto.response.FileInfoResponse;
import ru.loonolud.potterfox.model.IconInfoEntity;
import ru.loonolud.potterfox.repositiry.IconInfoRepository;
import ru.loonolud.potterfox.service.IconInfoService;
import ru.loonolud.potterfox.service.IconService;

@Slf4j
@Service
@RequiredArgsConstructor
public class IconInfoServiceImpl implements IconInfoService {

    private final IconInfoRepository iconInfoRepository;

    private final IconService iconService;

    @Override
    public FileInfoResponse saveFile(MultipartFile file) {
        IconInfoEntity e = IconInfoEntity.builder()
                .mongoId(iconService.saveFile(file))
                .fileName(file.getOriginalFilename())
                .mimeType(file.getContentType())
                .size(file.getSize())
                .build();

        return toResponse(iconInfoRepository.save(e));
    }

    @Override
    public FileInfoResponse getFileInfo(String id) {
        return toResponse(iconInfoRepository.findByMongoId(id));
    }

    @Override
    public ResponseEntity<Resource> getFileContent(String id) {
        IconInfoEntity icon = iconInfoRepository.findByMongoId(id);
        return ResponseEntity
                .status(200)
                .header(HttpHeaders.CONTENT_TYPE, icon.getMimeType())
                .body(new ByteArrayResource(iconService.getFileContent(id)));
    }

    private FileInfoResponse toResponse(IconInfoEntity e) {
        return FileInfoResponse.builder()
                .id(e.getMongoId())
                .fileName(e.getFileName())
                .size(e.getSize())
                .mimeType(e.getMimeType())
                .build();
    }

}
