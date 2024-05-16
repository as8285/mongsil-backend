package com.nurung.mongsil.controller;

import com.nurung.mongsil.domain.Review;
import com.nurung.mongsil.domain.ReviewDTO;
import com.nurung.mongsil.domain.ReviewImage;
import com.nurung.mongsil.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/mongsil/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class ReviewController {

    @Autowired
    private ReviewService review;


    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @PostMapping("/review")
    public ResponseEntity<Review> create(ReviewDTO dto) throws IOException, IOException {

        // review부터 추가하여 revi_code가 담긴 review!
        Review vo = new Review();

        vo.setId(dto.getId());
        vo.setShopCode(dto.getShopCode());
        vo.setReviTitle(dto.getReviTitle());
        vo.setReviDesc(dto.getReviDesc());
        vo.setRating(dto.getRating());

        Review result = review.create(vo);

        log.info("result : " + result);

        if (dto.getFiles() != null) {
            // review_image에는 revi_code가 필요!
            for (MultipartFile file : dto.getFiles()) {
                ReviewImage imgVo = new ReviewImage();

                String fileName = file.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                String saveName = uploadPath + File.separator + "review" + File.separator + uuid + "_" + fileName;
                Path savePath = Paths.get(saveName);
                file.transferTo(savePath);

                imgVo.setReviUrl(saveName);
                imgVo.setReview(result);

                review.createImg(imgVo);
            }
        }


        return result != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}