package com.nurung.mongsil.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Table(name="review_image")
public class ReviewImage {
    @Id
    @Column(name="revi_img_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviImgCode;
    @Column(name="revi_url")
    private String reviUrl;
    @ManyToMany
    @JoinColumn(name="revi_code")
    @JsonIgnore
    private Review review;

}
