package DesignPatterns.DI;

/*
    This is an example of Dependency Injection design pattern

    According to the concept of Dependency Injection, if a class A is
    dependent on class B than B is the dependency of A, i.e., A needs some
    stuff from B to work properly

    now, the naive way of doing this is inheritance, nut Java doesn't allow
    multiple inheritance. Therefore, we'll have to initialize class B in
    class A.

    This causes the two classes to be tightly bound. Now if we need to replace
    class B with class B1 which is an upgrade over class B (eg:- new databases
    and services etc.) then we'll have to change the tightly bound classes.
    This creates problems since we need to make a lot of changes if there are
    hundreds of classes depending on some other classes.

    To solve this problem, instead of relying on initializing classes, we will
    create interfaces of both class A and B. Therefore, instead of creating a
    dependency between specific classes we will create dependency between
    two types of classes. Generalization sorta thing.

 */

// let's talk about the injection part in dependency injection


// Database interface is the dependency for user
interface Database {
    public String dbname();
}

// there are two type of databases here
class oracle implements Database {
    @Override
    public String dbname() {
        return "oracle";
    }
}

class mysql implements Database {
    @Override
    public String dbname() {
        return "mysql";
    }
}


// interface user is for clients
interface user {
    public void displayName();
}

// this is a client of type user
class clientA implements user {

    // now this clientA guy needs a database, but we don't
    // want to give him oracle or mysql, this guy needs only a
    // database, so database it is

    // database interface is declared
    Database db;

    /*
     and passed as a parameter to the constructor.
     At each instance the database will be initialized
     without being specific to the type.
     by doing this we don't need to make any changes to
     the either of the classes, we just need to make changes to
     what type of database object is being used
    */
    clientA(Database d) {
        this.db = d;
    }

    @Override
    public void displayName() {
        // this will display the name of the database
        // depending on the type of database object initialized
        System.out.println("Database name: " + this.db.dbname());
    }
}


public class DepInjectDemo {
    // now this is the main method
    public static void DI_Demo() {

        // a database of type mysql is being used here
        // the interface Database is now initialized with
        // a mysql database
        Database db1 = new mysql();
        // passing this mysql dependency to the clientA type user
        // the client doesn't know which type of database it is
        // all that matters is that it has a database
        user u1 = new clientA(db1);

        // now calling the displayName function will invoke the mysql type database
        u1.displayName();

        // output:-
        // Database name: mysql
    }
}
