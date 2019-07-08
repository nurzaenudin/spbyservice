/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.DAO.AgendaDao;
import com.nurzaenudin.spbyservice.entity.Agenda;
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
public class AgendaController {
    @Autowired
    private AgendaDao agendaDao;
    
    @GetMapping(path = "/agendakomen")

    
    @ResponseBody
    public String agendakomen() {
        return "ini agenda komen";
    }
    
    
    @GetMapping("/agendas")
    @ResponseBody
    public Page<Agenda> getAllAgendas(Pageable pageable) {
        return agendaDao.findAll(pageable);
    }
}
