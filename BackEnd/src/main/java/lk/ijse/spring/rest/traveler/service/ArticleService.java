package lk.ijse.spring.rest.traveler.service;

import lk.ijse.spring.rest.traveler.dto.ArticleDTO;

import java.util.ArrayList;

public interface ArticleService {

    public boolean publishArcticel(ArticleDTO dto) throws Exception;

    public ArrayList<ArticleDTO> blogs() throws Exception;

    public ArrayList<ArticleDTO> topTenRatedBlogs() throws Exception;
}
