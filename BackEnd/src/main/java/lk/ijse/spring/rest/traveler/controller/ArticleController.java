package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.dto.ArticleDTO;
import lk.ijse.spring.rest.traveler.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean publishedAPost(@RequestBody ArticleDTO articleDTO) {
        try {
            return service.publishArcticel(articleDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ArticleDTO> articles() {
        try {
            return service.blogs();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/topTenRatedBlogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ArticleDTO> topTenRatedBlogs() {
        try {
            return service.topTenRatedBlogs();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
