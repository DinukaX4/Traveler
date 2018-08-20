package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.service.ImageDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/images")
public class ImageDownloadController {
    @Autowired
    private ImageDownloadService imageDownloadService;

    @GetMapping(value = "/download1", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> downloadFile1(@RequestParam("path") String path) throws IOException {
        return imageDownloadService.downloadFile1(path);
    }

}
