package com.nurung.mongsil.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @Column(name = "res_id")
    private String resId;
    @Column(name = "res_date")
    private String resDate;
    @Column(name = "res_start")
    private String resStart;
    @Column(name = "res_end")
    private String resEnd;
    @Column(name = "res_price")
    private int resPrice;
    @Column(name = "res_yn")
    private String resYn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

}
