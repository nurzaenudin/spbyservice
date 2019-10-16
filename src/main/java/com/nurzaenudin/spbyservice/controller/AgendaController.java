/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.DAO.AgendaDao;
import com.nurzaenudin.spbyservice.entity.Agenda;
import com.nurzaenudin.spbyservice.entity.Spbysakti;
import java.util.List;
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
@RequestMapping(path="/agenda")
public class AgendaController {
    @Autowired
    private AgendaDao agendaDao;
    
    @GetMapping(path = "/komen")    
    @ResponseBody
    public String agendakomen() {
        return "ini agenda komen";
    }
    
    
    @GetMapping("/all")
    @ResponseBody
    public Page<Agenda> getAllAgendas(Pageable pageable) {
        return agendaDao.findAll(pageable);
    }
    
    @PostMapping(path="/tambah")
    @ResponseBody
    public void tambahAgenda(@RequestBody @Valid Agenda agenda) {
        agendaDao.save(agenda);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public void updateAgenda(@RequestBody @Valid Agenda agenda, @PathVariable Long id){
        Optional <Agenda> a = agendaDao.findById(id);
        if (!a.isPresent())
            return;
        agenda.setId(id);
        agendaDao.save(agenda);   
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    public String hapusAgenda (@PathVariable Long id){
        agendaDao.deleteById(id);
        return "Hapus Berhasil";
    }
    

    
}
