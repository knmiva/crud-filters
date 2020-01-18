package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UsersDAOFactory {

    final static String FormHibernateDAO = "Hibernate";
    final static String FormJdbcDAO = "JDBC";

    public static String getFormDAO() {
        try (FileInputStream fileInputStream = new FileInputStream(UsersDAOFactory.class.getClassLoader()
                .getResource("dao.properties").getPath())) {
            Properties typeDaoProp = new Properties();
            typeDaoProp.load(fileInputStream);
            return typeDaoProp.getProperty("formDAO");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static UsersDAO getUsersDAO() {
        String formDAO = getFormDAO();
        if (FormHibernateDAO.equals(formDAO)) {
            return new UsersDAOHibernate();
        } else if (FormJdbcDAO.equals(formDAO)) {
            return new UsersDAOJDBC();
        }
        return null;
    }
}
