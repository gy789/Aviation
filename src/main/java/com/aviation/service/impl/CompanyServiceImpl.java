package com.aviation.service.impl;

import com.aviation.entity.Company;
import com.aviation.mapper.CompanyMapper;
import com.aviation.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired(required = false)
    private CompanyMapper companyMapper;

    @Override
    public List<Company> getAllCompany() {
        return companyMapper.getAllCompany();
    }

    @Override
    public int addCompany(Map<String,Object> params) {
        return companyMapper.addCompany(params);
    }

    @Override
    public int delCompany(String company_number) {
        return companyMapper.delCompany(company_number);
    }

    @Override
    public Company getCompanyInfo(Map<String,Object> params) {
        return companyMapper.getCompanyInfo(params);
    }

    @Override
    public int updateCompanyInfo(Company company) {
        return companyMapper.updateCompanyInfo(company);
    }
}
