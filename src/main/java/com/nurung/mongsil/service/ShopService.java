package com.nurung.mongsil.service;

import com.nurung.mongsil.domain.Shop;
import com.nurung.mongsil.repo.ShopDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopDAO shopdao;
    public void create(Shop shop){
        shopdao.save(shop);
    }
    public List<Shop> select(){
        return shopdao.findAll();

    }
    public Shop select(String shopId){
        return shopdao.findById(shopId).orElse(null);
    }
    public void update(Shop shop){
        if(shopdao.existsById(shop.getShopId())){
            shopdao.save(shop);
        }

    }
    public void delete(String shopId){
        if(shopdao.existsById(shopId)){
            shopdao.deleteById(shopId);
        }
    }
}
