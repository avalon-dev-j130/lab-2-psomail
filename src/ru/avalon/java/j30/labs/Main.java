package ru.avalon.java.j30.labs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle Certified Professional Java Programmer"
 * <p>
 * Тема: "JDBC - Java Database Connectivity" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main {

    private static final String CONFIGS = "resourses/config.properties";
    private static Properties configs = new Properties();
    /**
     * Точка входа в приложение
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        /*
         * TODO #01 Подключите к проекту все библиотеки, необходимые для соединения с СУБД.
         */
        try (Connection connection = getConnection()) {
            ProductCode code = new ProductCode("MT", 'N', "Movies");
            code.save(connection);
            printAllCodes(connection);
            code.setCode("MV");
            code.save(connection);
            printAllCodes(connection);
        }
        /*
         * TODO #14 Средствами отладчика проверьте корректность работы программы
         */
    }
    /**
     * Выводит в кодсоль все коды товаров
     * 
     * @param connection действительное соединение с базой данных
     * @throws SQLException 
     */    
    private static void printAllCodes(Connection connection) throws SQLException, IOException {
        Collection<ProductCode> codes = ProductCode.all(connection);
        for (ProductCode code : codes) {
            System.out.println(code);
        }
    }
    /**
     * Возвращает URL, описывающий месторасположение базы данных
     * 
     * @return URL в виде объекта класса {@link String}
     */
    private static String getUrl() throws IOException{
        /*
         * TODO #02 Реализуйте метод getUrl
         */
        return  configs.getProperty("database.driver") + ":" + configs.getProperty("database.path") +
                "/" + configs.getProperty("database.name");

     //   throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает параметры соединения
     * 
     * @return Объект класса {@link Properties}, содержащий параметры user и 
     * password
     */
    private static Properties getProperties(String path)throws IOException {
        /*
         * TODO #03 Реализуйте метод getProperties
         */
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try (InputStream stream = classLoader.getResourceAsStream(CONFIGS)) {
            configs.load(stream);
            return configs;
        }
      //  throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает соединение с базой данных Sample
     * 
     * @return объект типа {@link Connection}
     * @throws SQLException 
     */
    private static Connection getConnection() throws IOException,SQLException {
        /*
         * TODO #04 Реализуйте метод getConnection
         */

        configs = getProperties(CONFIGS);

        String url = getUrl();
        String username = configs.getProperty("database.user");
        String password = configs.getProperty("database.password");

        return DriverManager.getConnection(url, username, password);

//        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
