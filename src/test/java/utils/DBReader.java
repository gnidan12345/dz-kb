package utils;

import api.methods.Projects;
import api.models.args.projects.CreateProject;
import api.models.args.projects.ProjectDetails;
import api.steps.ProjectApiSteps;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private final static String URL = "jdbc:mariadb://localhost:3306/kanboard";

    private final static String USER_NAME = "kanboard";
    private final static String USER_PASSWORD = "kanboard-secret";

    private final static String QUERY_SELECT_ALL = "select * from projects";

    private final static String QUERY_SELECT = "select * from projects where id=122";

    private final static String QUERY_UPDATE_LASTNAME = "update projects set name=? where id=?";

    public static List<ProjectDetails> getPropertiesFromDB() {

        List<ProjectDetails> projectProperties = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            Statement sqlStatement = connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(QUERY_SELECT_ALL);

            while (resultSet.next()) {
                ProjectDetails property = new ProjectDetails(resultSet.getInt("id"), resultSet.getString("name"));
                projectProperties.add(property);

            }
        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }

        return projectProperties;
    }

    public static  List<ProjectDetails> getSelectedProjectFromDB(){
        List<ProjectDetails> projectProperties = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            Statement sqlStatement = connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(QUERY_SELECT);

            while (resultSet.next()) {
                ProjectDetails property = new ProjectDetails(resultSet.getInt("id"), resultSet.getString("name"));
                projectProperties.add(property);

            }

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
        return projectProperties;
    }




    public static String updateProjectname(int id, String name) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_LASTNAME);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }


        return name;
    }

}
