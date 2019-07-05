/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.DAO;

import com.nurzaenudin.spbyservice.entity.Agenda;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author nurzaenudin
 */
public interface AgendaDao extends PagingAndSortingRepository<Agenda, String>{
    
}
