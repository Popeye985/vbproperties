package org.beta.vzw.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException {
        Properties props = new Properties();
        try(FileReader fReader = new FileReader ("db.properties")){
            props.load(fReader);
        }
        String connString = props.getProperty("db.con.url");
        System.out.println(connString);
        try(Connection con = DriverManager.getConnection(connString, props);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from persoon")){
            while(rs.next()){
                int id = rs.getInt("id");
                String voornaam = rs.getString("voornaam");
                System.out.printf("%d) %s%n", id, voornaam);
            }


            }


    }
}
