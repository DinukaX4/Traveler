package lk.ijse.spring.rest.traveler.service;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface ImageDownloadService {

    public ResponseEntity<InputStreamResource> downloadFile1(@RequestParam("path") String path) throws IOException;
}
