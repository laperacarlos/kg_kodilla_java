package com.kodilla.hibernate.manytomany.facade;

public class SearchEngineException extends  Exception {
    public static String ERR_EMPLOYEE_NOT_FOUND = "Searched employee not found in database";
    public static String ERR_COMPANY_NOT_FOUND = "Searched company not found in database";

    public SearchEngineException(String message) {
        super(message);
    }
}
