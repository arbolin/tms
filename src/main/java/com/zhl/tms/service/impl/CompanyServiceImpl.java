package com.zhl.tms.service.impl;

import com.zhl.tms.service.CompanyService;
import com.zhl.tms.domain.Company;
import com.zhl.tms.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Company.
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

    private final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
    
    @Inject
    private CompanyRepository companyRepository;

    /**
     * Save a company.
     *
     * @param company the entity to save
     * @return the persisted entity
     */
    public Company save(Company company) {
        log.debug("Request to save Company : {}", company);
        Company result = companyRepository.save(company);
        return result;
    }

    /**
     *  Get all the companies.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Company> findAll(Pageable pageable) {
        log.debug("Request to get all Companies");
        Page<Company> result = companyRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one company by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public Company findOne(Long id) {
        log.debug("Request to get Company : {}", id);
        Company company = companyRepository.findOne(id);
        return company;
    }

    /**
     *  Delete the  company by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Company : {}", id);
        companyRepository.delete(id);
    }
}
