package Oefeningen.ContactsGUI.DatabankAccess.jdbc;

import Oefeningen.ContactsGUI.DatabankAccess.Person;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Tester {
    public static void main(String[] args){
        Person person =  new Person(0, "Jules", "Vervaeke");
        JDBCDataAccessProvider dap = new JDBCDataAccessProvider();
        try {
            JDBCDataAccessContext dac = dap.getDataAccessContext();
            dac.getPersonDAO().createPerson(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
