package lk.ijse.spring.rest.traveler.service.impl;

import lk.ijse.spring.rest.traveler.service.ImageDownloadService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ImageDownloadServiceImpl implements ImageDownloadService {
    @Override
    public ResponseEntity<InputStreamResource> downloadFile1(String path) throws IOException {
        File file = new File(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length())
                .body(resource);
    }
}
