package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {
    @Query(value = "select a.articleName,a.content from Article a,Rating r  where a.articleName=r.articleName ORDER BY r.star DESC LIMIT 10", nativeQuery = true)
    List<Object[]> ratingBloges();
}
