package Project;


import java.sql.*;

/*
This class creates a connection to the MySQL database
with the given password

it returns the created statement
*/


class CreateConnection {
    public Statement initiate(String password) {
        try{
            String exec = "jdbc:mysql://localhost/?user=root&password="+password;
            Class.forName("java.sql.Driver");
            Connection dbCon = DriverManager.getConnection(exec);
            Statement s = dbCon.createStatement();
            
            return s;

        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Statement initiate(String DBName, String password) {
        try{
            String exec = "jdbc:mysql://localhost/"+DBName;
            Class.forName("java.sql.Driver");
            Connection dbCon = DriverManager.getConnection(exec,"root", password);
            Statement s = dbCon.createStatement();
            
            return s;

        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
