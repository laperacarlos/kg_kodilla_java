package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchEngineFacadeTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private  CompanyDao companyDao;

    @Autowired
    private SearchEngineFacade searchEngineFacade;

    @Test
    public void testSearchEngineFacadeEmployee() throws SearchEngineException {
        //given
        Employee marryClarkson = new Employee("Marry", "Clarkson");
        Employee mariaKovalsky = new Employee("Maria", "Kovalsky");

        employeeDao.save(marryClarkson);
        employeeDao.save(mariaKovalsky);

        //when
        List<Employee> resultList = searchEngineFacade.searchEmployeeUsingPhrase("Mar");

        //then
        assertEquals(2, resultList.size());

        //clean
        employeeDao.deleteAll();
    }

    @Test
    public void testSearchEngineFacadeCompany() throws SearchEngineException {
        //given
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(greyMatter);
        companyDao.save(dataMasters);

        //when
        List<Company> resultList = searchEngineFacade.searchCompanyUsingPhrase("ta");

        //then
        assertEquals(1, resultList.size());

        //clean
        companyDao.deleteAll();
    }
}