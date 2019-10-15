/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.DAO.SpbysaktiDao;
import com.nurzaenudin.spbyservice.entity.Spbysakti;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nurzaenudin
 */

@Controller
@RequestMapping(path="/spby")
public class SpbysaktiController {
    @Autowired
    private SpbysaktiDao spbysaktidao;
    
    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "ini home";
    }
        
    @PostMapping(path="/tambah")
    @ResponseBody
    public void tambahSpbysakti(@RequestBody @Valid Spbysakti spbysakti) {
        spbysaktidao.save(spbysakti);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public Page<Spbysakti> getAllSpbysaktis(Pageable pageable) {
        return spbysaktidao.findAll(pageable);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public void updateSpbysakti(@RequestBody @Valid Spbysakti spbysakti, @PathVariable String id){
        Optional <Spbysakti> s = spbysaktidao.findById(id);
        if (!s.isPresent())
            return;
        spbysakti.setId(id);
        spbysaktidao.save(spbysakti);   
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    public String hapusSpbysakti (@PathVariable String id){
        spbysaktidao.deleteById(id);
        return "Hapus Berhasil";
    }
}
