package com.nurung.mongsil.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QShop is a Querydsl query type for Shop
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShop extends EntityPathBase<Shop> {

    private static final long serialVersionUID = 344845391L;

    public static final QShop shop = new QShop("shop");

    public final StringPath shopAddress = createString("shopAddress");

    public final StringPath shopEnd = createString("shopEnd");

    public final StringPath shopHoliday = createString("shopHoliday");

    public final StringPath shopId = createString("shopId");

    public final StringPath shopName = createString("shopName");

    public final StringPath shopPassword = createString("shopPassword");

    public final StringPath shopPhone = createString("shopPhone");

    public final StringPath shopStart = createString("shopStart");

    public QShop(String variable) {
        super(Shop.class, forVariable(variable));
    }

    public QShop(Path<? extends Shop> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShop(PathMetadata metadata) {
        super(Shop.class, metadata);
    }

}

