package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEngineFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchEngineFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchEngineFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> searchCompanyUsingPhrase(final String querySigns) throws SearchEngineException {
        LOGGER.info("Searching company list with phrase: " + querySigns);
        List<Company> retrievedList = companyDao.retrieveCompanyWithPhraseInName(querySigns);

        if (retrievedList.size() == 0) {
            LOGGER.error(SearchEngineException.ERR_COMPANY_NOT_FOUND);
            throw new SearchEngineException(SearchEngineException.ERR_COMPANY_NOT_FOUND);
        } else {
            LOGGER.info("Printing company list.");
            for (Company company : retrievedList) {
                System.out.println(company.getName());
            }
        }
        return retrievedList;
    }

    public List<Employee> searchEmployeeUsingPhrase(final String querySigns) throws SearchEngineException {
        LOGGER.info("Searching employee list with phrase: " + querySigns);
        List<Employee> retrievedList = employeeDao.retrieveEmployeeWithPhraseInFirstname(querySigns);

        if (retrievedList.size() == 0) {
            LOGGER.error(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
            throw new SearchEngineException(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
        } else {
            LOGGER.info("Printing employee list.");
            for (Employee employee : retrievedList) {
                System.out.println(employee.getFirstname() + " " + employee.getLastname());
            }
        }
        return retrievedList;
    }
}
