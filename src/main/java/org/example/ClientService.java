package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public Long create(String name) throws SQLException {
        String sqlCreateClient = "INSERT INTO client1 (NAME) VALUES (?)";
        Databese databese = new Databese();
        PreparedStatement createClient = databese.getConnection().prepareStatement(
                    sqlCreateClient, Statement.RETURN_GENERATED_KEYS);
                    createClient.setString(1, name);
        createClient.executeUpdate();
        ResultSet resultSet = createClient.getGeneratedKeys();
       resultSet.next();
            return resultSet.getLong(1);

    }
    public String getById(long id)  throws SQLException {
        String sqlGetById = "SELECT * FROM client1 WHERE ID = ?";
        PreparedStatement getByIdSt = Databese.getConnection().prepareStatement(sqlGetById);
        getByIdSt.setLong(1, id);
        ResultSet resultSet = getByIdSt.executeQuery();
        resultSet.next();
        return resultSet.getString("NAME");
    }
    public void setName(Long id, String name) throws SQLException {
        String sqlSetName = "UPDATE client1 SET NAME = ? WHERE ID = ?";
        PreparedStatement setNameSt = Databese.getConnection().prepareStatement(sqlSetName);
        setNameSt.setString(1, name);
        setNameSt.setLong(2, id);
        setNameSt.executeUpdate();
    }
    public void deleteById(long id) throws SQLException {
        String sqlDeleteById = "DELETE FROM client1 WHERE ID = ?";
        PreparedStatement deleteByIdSt = Databese.getConnection().prepareStatement(sqlDeleteById);
        deleteByIdSt.setLong(1, id);
        deleteByIdSt.executeUpdate();
    }
    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<Client>();
        String sqlGetClients = "SELECT * FROM client1";
        PreparedStatement getClientsSt = Databese.getConnection().prepareStatement(sqlGetClients);
        ResultSet resultSet = getClientsSt.executeQuery();
        while (resultSet.next()) {
            clients.add(new Client(
                    resultSet.getString("NAME"),
                    resultSet.getInt("ID")
            ));
        }
    return clients;
    }

}