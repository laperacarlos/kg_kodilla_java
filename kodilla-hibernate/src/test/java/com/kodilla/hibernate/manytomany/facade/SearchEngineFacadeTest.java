package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchEngineFacadeTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private SearchEngineFacade searchEngineFacade;

    @Test
    public void testSearchEngineFacadeEmployee() {
        //given
        Employee marryClarkson = new Employee("Marry", "Clarkson");
        Employee mariaKovalsky = new Employee("Maria", "Kovalsky");

        employeeDao.save(marryClarkson);
        int marryCId = marryClarkson.getId();
        employeeDao.save(mariaKovalsky);
        int mariaKId = mariaKovalsky.getId();

        //when&then
        try {
            searchEngineFacade.searchEmployeeUsingPhrase("Mar");
        } catch (SearchEngineException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                employeeDao.deleteById(marryCId);
                employeeDao.deleteById(mariaKId);
            } catch (Exception e) {
                //DoNothing
            }
        }
    }

    @Test
    public void testSearchEngineFacadeCompany() {
        //given
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();

        //when&then
        try {
            searchEngineFacade.searchCompanyUsingPhrase("ta");
        } catch (SearchEngineException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                companyDao.deleteById(greyMatterId);
                companyDao.deleteById(dataMastersId);
            } catch (Exception e) {
                //DoNothing
            }
        }
    }
}