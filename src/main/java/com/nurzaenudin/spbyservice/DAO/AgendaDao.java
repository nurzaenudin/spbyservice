/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.DAO;

import com.nurzaenudin.spbyservice.entity.Agenda;
import com.nurzaenudin.spbyservice.entity.Spbysakti;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nurzaenudin
 */

@Repository
public interface AgendaDao extends PagingAndSortingRepository<Agenda, Long>{
    
}
