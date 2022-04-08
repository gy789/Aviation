package com.aviation.service.impl;

import com.aviation.entity.Company;
import com.aviation.mapper.CompanyMapper;
import com.aviation.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired(required = false)
    private CompanyMapper companyMapper;

    @Override
    public List<Company> getAllCompany() {
        return companyMapper.getAllCompany();
    }

    @Override
    public int addCompany(Company company) {
        return companyMapper.addCompany(company);
    }

    @Override
    public int delCompany(int company_id) {
        return companyMapper.delCompany(company_id);
    }

    @Override
    public Company getCompanyInfo(int company_id) {
        return companyMapper.getCompanyInfo(company_id);
    }

    @Override
    public int updateCompanyInfo(Company company) {
        return companyMapper.updateCompanyInfo(company);
    }
}
