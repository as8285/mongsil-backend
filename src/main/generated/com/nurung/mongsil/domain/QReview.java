package com.nurung.mongsil.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 652744305L;

    public static final QReview review = new QReview("review");

    public final StringPath id = createString("id");

    public final ListPath<ReviewImage, QReviewImage> images = this.<ReviewImage, QReviewImage>createList("images", ReviewImage.class, QReviewImage.class, PathInits.DIRECT2);

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final NumberPath<Integer> reviCode = createNumber("reviCode", Integer.class);

    public final DateTimePath<java.util.Date> reviDate = createDateTime("reviDate", java.util.Date.class);

    public final StringPath reviDesc = createString("reviDesc");

    public final DateTimePath<java.util.Date> reviRes = createDateTime("reviRes", java.util.Date.class);

    public final StringPath reviTitle = createString("reviTitle");

    public final NumberPath<Integer> shopCode = createNumber("shopCode", Integer.class);

    public QReview(String variable) {
        super(Review.class, forVariable(variable));
    }

    public QReview(Path<? extends Review> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReview(PathMetadata metadata) {
        super(Review.class, metadata);
    }

}

