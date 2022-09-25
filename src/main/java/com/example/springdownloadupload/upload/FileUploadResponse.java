package com.example.springdownloadupload.upload;

import lombok.Data;

@Data
public class FileUploadResponse {
    private String fileName;
    private String download;
    private long size;
}
