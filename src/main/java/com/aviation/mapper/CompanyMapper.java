package com.aviation.mapper;

import com.aviation.entity.Company;

import java.util.List;

public interface CompanyMapper {
    List<Company> getAllCompany();
    int addCompany(Company company);
    int delCompany(int company_id);
    Company getCompanyInfo(int company_id);
    int updateCompanyInfo(Company company);
}
