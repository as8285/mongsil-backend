package com.nurung.mongsil.repo;

import com.nurung.mongsil.domain.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewImageDAO extends JpaRepository<ReviewImage,Integer> {
    @Query(value="SELECT * FROM review_image WHERE revi_code = :code", nativeQuery = true)
    List<ReviewImage> findByReviCode(@Param("code") Integer code);

}

