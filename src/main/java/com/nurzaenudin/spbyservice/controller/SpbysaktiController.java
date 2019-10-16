/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.DAO.AgendaDao;
import com.nurzaenudin.spbyservice.DAO.SpbysaktiDao;
import com.nurzaenudin.spbyservice.entity.Agenda;
import com.nurzaenudin.spbyservice.entity.Spbysakti;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.Null;
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
public class SpbysaktiController {
    @Autowired
    private SpbysaktiDao spbysaktidao;
    
    @Autowired
    private AgendaDao agendadao;
    
    @GetMapping("/spby/home")
    @ResponseBody
    public String home(){
        return "ini home";
    }
        
    @PostMapping(path="/spby/tambah")
    @ResponseBody
    public void tambahSpbysakti(@RequestBody @Valid Spbysakti spbysakti) {
        spbysaktidao.save(spbysakti);
    }
    
    @GetMapping("/spby/all")
    @ResponseBody
    public Page<Spbysakti> getAllSpbysaktis(Pageable pageable) {
        System.out.println("Ini iBu budi ");
        return spbysaktidao.findAll(pageable);
    }
    
    @PutMapping("/spby/{id}")
    @ResponseBody
    public void updateSpbysakti(@RequestBody @Valid Spbysakti spbysakti, @PathVariable String id){
        Optional <Spbysakti> s = spbysaktidao.findById(id);
        if (!s.isPresent())
            return;
        spbysakti.setId(id);
        Agenda agenda=spbysakti.getAgenda();
        System.out.println("ini agenda" + agenda);
        
        if( agenda != null){
            agenda= agendadao.findById(spbysakti.getAgenda().getId()).get();        
        }
        spbysakti.setAgenda(agenda);
        System.out.println("ini agenda" + agenda);
        spbysaktidao.save(spbysakti); 
        System.out.println("berhasil simpan "+spbysakti);
    }
    
    @DeleteMapping("/spby/{id}")
    @ResponseBody
    public String hapusSpbysakti (@PathVariable String id){
        spbysaktidao.deleteById(id);
        return "Hapus Berhasil";
    }
    
//    @PutMapping("/{id}")
//    @ResponseBody
//    public void updateSpbyAgenda(@RequestBody @Valid Spbysakti spbysakti, @PathVariable String id){
//        Optional <Spbysakti> s = spbysaktidao.findById(id);
//        if (!s.isPresent())
//            return;
//        spbysakti.setId(id);
//        spbysaktidao.save(spbysakti);   
//    }
        

    @GetMapping("spby/{id}")
    @ResponseBody
    public Optional getSpbysakti(@PathVariable String id){
        System.out.println("ini adalah id " + id);        
        return spbysaktidao.findById(id);
 
    }
    
    
}
