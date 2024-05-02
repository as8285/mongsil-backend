package com.nurung.mongsil.controller;

import com.nurung.mongsil.domain.Shop;
import com.nurung.mongsil.domain.User;
import com.nurung.mongsil.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongsil/*")
public class ShopController {
    @Autowired
    ShopService shopservice;
    @PostMapping("/shop")
    public ResponseEntity create(@RequestBody Shop shop){
        shopservice.create(shop);
        return ResponseEntity .status(HttpStatus.OK).build();

    }
    @GetMapping("/shop")
    public ResponseEntity <List<Shop>> select(){
        List<Shop>list = shopservice.select();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/shop/{shopId}")
    public ResponseEntity select(@PathVariable("shopId")String shopId){
        Shop shop = shopservice.select(shopId);
        return ResponseEntity.status(HttpStatus.OK).body(shopId);

    }
    @PutMapping("/shop")
    public ResponseEntity update(@RequestBody Shop shop){
        shopservice.update(shop);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/shop/{shopId}")
    public ResponseEntity delete(@PathVariable("shopId")String shopId){
        shopservice.delete(shopId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
