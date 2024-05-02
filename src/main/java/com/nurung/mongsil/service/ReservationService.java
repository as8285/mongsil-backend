package com.nurung.mongsil.service;

import com.nurung.mongsil.domain.Reservation;
import com.nurung.mongsil.repo.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDAO resdao;
    public void create(Reservation res){

        resdao.save(res);
    }
    public List<Reservation>select(){
        return resdao.findAll();
    }
    public Reservation select(String resId){
        return resdao.findById(resId).orElse(null);


    }
    public void update(Reservation res) {
        if (resdao.existsById(res.getResId())) {
            resdao.save(res);
        }
    }
    public void delete(String resId){
        if(resdao.existsById(resId)){
            resdao.deleteById(resId);

        }
    }
}

