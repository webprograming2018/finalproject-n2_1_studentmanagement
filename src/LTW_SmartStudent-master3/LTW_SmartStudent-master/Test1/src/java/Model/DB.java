/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SONY
 */
public class DB {
    public String host, dbName;
    public int port;
    public String user, pass, URL;

    public DB(String host, String dbName, int port, String user, String pass) {
        this.host = host;
        this.dbName = dbName;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.URL = "jdbc:mysql://"+host+":"+port+";databaseName="+dbName+";user="+user+";password="+pass+";";
    }

    public DB(String host, String dbName, int port) {
        this.host = host;
        this.dbName = dbName;
        this.port = port;
        this.URL = "jdbc:mysql://"+host+":"+port+";databaseName="+dbName+";user=root;password=;";
    }
    
    public String getHost() {
        return host;
    }

    public String getDbName() {
        return dbName;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getURL() {
        return URL;
    }
}
