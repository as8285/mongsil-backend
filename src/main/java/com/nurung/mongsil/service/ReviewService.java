package com.nurung.mongsil.service;

import com.nurung.mongsil.domain.Review;
import com.nurung.mongsil.domain.ReviewImage;
import com.nurung.mongsil.repo.ReviewDAO;
import com.nurung.mongsil.repo.ReviewImageDAO;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReviewService {
    @Autowired
    private ReviewDAO review;
    @Autowired
    private ReviewImageDAO image;
    public Review create(Review vo){
        return review.save(vo);
    }
    public ReviewImage createImg(ReviewImage vo){
        return image.save(vo);
    }
    public Page<Review> viewAll(Pageable pageable, BooleanBuilder builder) {
        return review.findAll(builder, pageable);
    }

    public List<ReviewImage> viewImages(int code) {
        return image.findByReviCode(code);
    }

}
