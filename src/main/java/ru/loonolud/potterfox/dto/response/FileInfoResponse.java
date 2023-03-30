package ru.loonolud.potterfox.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileInfoResponse {

    private String id;

    private Long size;

    private String fileName;

    private String mimeType;

}

