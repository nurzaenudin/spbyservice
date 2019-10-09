/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.DAO.SpbysaktiDao;
import com.nurzaenudin.spbyservice.entity.Spbysakti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nurzaenudin
 */

@Controller
public class SpbysaktiController {
    @Autowired
    private SpbysaktiDao spbysaktidao;
    
    public void tambahSpbysakti(Spbysakti spbysakti) {
        spbysaktidao.save(spbysakti);
    }
    
    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "ini home";
    }
    
        @GetMapping("/spbysaktis")
    @ResponseBody
    public Page<Spbysakti> getAllSpbysaktis(Pageable pageable) {
        return spbysaktidao.findAll(pageable);
    }
}
