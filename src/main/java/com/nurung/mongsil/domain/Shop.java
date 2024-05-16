package com.nurung.mongsil.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Shop {
    @Id
    @Column(name = "shop_id")
    private String shopId ;
    @Column(name = "shop_password")
    private String shopPassword;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "shop_address")
    private String shopAddress;
    @Column(name = "shop_phone")
    private String shopPhone;
    @Column(name = "shop_start")
    private String shopStart;
    @Column(name = "shop_end")
    private String shopEnd;
    @Column(name = "shop_holiday")
    private String shopHoliday;

}
