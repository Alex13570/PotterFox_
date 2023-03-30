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
import ru.loonolud.potterfox.exceptions.file.FileProcessingException;
import ru.loonolud.potterfox.model.IconEntity;
import ru.loonolud.potterfox.repositiry.IconRepository;
import ru.loonolud.potterfox.service.IconService;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class IconServiceImpl implements IconService {

    private final IconRepository fileRepository;

    @Override
    public String saveFile(MultipartFile file) {
        try {
            return fileRepository.insert(
                        IconEntity.builder()
                            .content(new Binary(BsonBinarySubType.BINARY, file.getBytes()))
                            .build())
                    .getId();

        } catch (IOException e) {
            log.error("Cannot save file {}", file.getOriginalFilename());
            throw new FileProcessingException("Cannot save file " + file.getOriginalFilename());
        }
    }

    @Override
    public byte[] getFileContent(String id) {
        log.info("Requested file content {}", id);
        IconEntity e = fileRepository.findById(id).orElseThrow(FileProcessingException::new);
        return e.getContent().getData();
    }

}
