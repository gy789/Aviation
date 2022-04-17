package com.aviation.mapper;

import com.aviation.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CompanyMapper {
    List<Company> getAllCompany();
    int addCompany(@Param("params") Map<String,Object> params);
    int delCompany(String company_number);
    Company getCompanyInfo(@Param("params")Map<String,Object> params);
    int updateCompanyInfo(Company company);


}
