package ru.avalon.java.j30.labs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Класс описывает представление о коде товара и отражает соответствующую 
 * таблицу базы данных Sample (таблица PRODUCT_CODE).
 * 
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class ProductCode {
    /**
     * Код товара
     */
    private String code;
    /**
     * Кода скидки
     */
    private char discountCode;
    /**
     * Описание
     */
    private String description;
    /**
     * Основной конструктор типа {@link ProductCode}
     * 
     * @param code код товара
     * @param discountCode код скидки
     * @param description описание 
     */
    public ProductCode(String code, char discountCode, String description) {
        this.code = code;
        this.discountCode = discountCode;
        this.description = description;
    }
    /**
     * Инициализирует объект значениями из переданного {@link ResultSet}
     * 
     * @param set {@link ResultSet}, полученный в результате запроса, 
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample.
     */
    private ProductCode(ResultSet set) throws SQLException{
        /*
         * TODO #05 реализуйте конструктор класса ProductCode
         */
        this.code = set.getString("code");
        this.discountCode = set.getString("discountCode").charAt(0);
        this.description = set.getString("description");

     //   throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает код товара
     * 
     * @return Объект типа {@link String}
     */
    public String getCode() {
        return code;
    }
    /**
     * Устанавливает код товара
     * 
     * @param code код товара
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * Возвращает код скидки
     * 
     * @return Объект типа {@link String}
     */
    public char getDiscountCode() {
        return discountCode;
    }
    /**
     * Устанавливает код скидки
     * 
     * @param discountCode код скидки
     */
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }
    /**
     * Возвращает описание
     * 
     * @return Объект типа {@link String}
     */
    public String getDescription() {
        return description;
    }
    /**
     * Устанавливает описание
     * 
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Хеш-функция типа {@link ProductCode}.
     * 
     * @return Значение хеш-кода объекта типа {@link ProductCode}
     */
    @Override
    public int hashCode() {
        /*
         * TODO #06 Реализуйте метод hashCode
         */
        return Objects.hash(code, discountCode, description);

        //   throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Сравнивает некоторый произвольный объект с текущим объектом типа 
     * {@link ProductCode}
     * 
     * @param obj Объект, скоторым сравнивается текущий объект.
     * @return true, если объект obj тождественен текущему объекту. В обратном 
     * случае - false.
     */
    @Override
    public boolean equals(Object obj) {
        /*
         * TODO #07 Реализуйте метод equals
         */
        if (this == obj) return true;

        if(obj instanceof ProductCode){

            ProductCode productCode = (ProductCode) obj;

            return code.equals(productCode.getCode()) && description.equals(productCode.getDescription()) && discountCode == productCode.getDiscountCode();
        }

        return false;

      // throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает строковое представление кода товара.
     * 
     * @return Объект типа {@link String}
     */
    @Override
    public String toString() {
        /*
         * TODO #08 Реализуйте метод toString
         */
       return "code = " + code + "; discountCode = " + discountCode + "; description = " + description;
       // throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на выбор всех записей из таблицы PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getSelectQuery(Connection connection) throws SQLException, IOException {
        /*
         * TODO #09 Реализуйте метод getSelectQuery
         */
        QueryProvider queryProvider = new QueryProvider();
        String query = queryProvider.getQuery("select.product_code");
        return connection.prepareStatement(query);

        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на добавление записи в таблицу PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getInsertQuery(Connection connection) throws SQLException, IOException {
        /*
         * TODO #10 Реализуйте метод getInsertQuery
         */
        QueryProvider queryProvider = new QueryProvider();
        String query = queryProvider.getQuery("insert.product_code");
        PreparedStatement statement = connection.prepareStatement(query);

        return statement;

      //  throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на обновление значений записи в таблице PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getUpdateQuery(Connection connection) throws SQLException, IOException {
        /*
         * TODO #11 Реализуйте метод getUpdateQuery
         */
        QueryProvider queryProvider = new QueryProvider();
        String query = queryProvider.getQuery("update.product_code");
        PreparedStatement statement = connection.prepareStatement(query);

        return statement;

 //       throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Преобразует {@link ResultSet} в коллекцию объектов типа {@link ProductCode}
     * 
     * @param set {@link ResultSet}, полученный в результате запроса, содержащего 
     * все поля таблицы PRODUCT_CODE базы данных Sample
     * @return Коллекция объектов типа {@link ProductCode}
     * @throws SQLException 
     */
    public static Collection<ProductCode> convert(ResultSet set) throws SQLException {
        /*
         * TODO #12 Реализуйте метод convert
         */
        Collection<ProductCode> productCodes = new LinkedList<>();
        while (set.next()){
            productCodes.add(new ProductCode(set));
        }
        return new ArrayList<>(productCodes);

      //  throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Сохраняет текущий объект в базе данных. 
     * <p>
     * Если запись ещё не существует, то выполняется запрос типа INSERT.
     * <p>
     * Если запись уже существует в базе данных, то выполняется запрос типа UPDATE.
     * 
     * @param connection действительное соединение с базой данных
     */
    public void save(Connection connection) throws SQLException, IOException {
        /*
         * TODO #13 Реализуйте метод convert
         */
        PreparedStatement statement = connection.prepareStatement("select * from PRODUCT_CODE");


        //    try (ResultSet result = getSelectQuery(connection).executeQuery()) {
        try (ResultSet result = statement.executeQuery()) {

                PreparedStatement statement1 = getInsertQuery(connection);

                Boolean operation = true;

                while (result.next()){
                    if(this.equals(new ProductCode(result))) {
                        operation = false;
                        break;
                    }
                    if(this.getCode().equals(result.getString("code"))) {
                        statement1 = getUpdateQuery(connection);
                        break;
                    }
                }
                if(operation) {
                    statement1.setString(1, String.valueOf(discountCode));
                    statement1.setString(2, description);
                    statement1.setString(3, code);
                    statement1.executeUpdate();
                }
            }


//
//        Collection<ProductCode> codes = all(connection);
//
//        PreparedStatement statement = getInsertQuery(connection);
//        Boolean operation = true;
//
//        for (ProductCode code : codes) {
//            if(code.equals(this)) {
//                operation = false;
//                break;
//            }
//
//            if(code.getCode().equals(this.code)) {
//                statement = getUpdateQuery(connection);
//                break;
//            }
//        }
//
//        if(operation) {
//            statement.setString(1, String.valueOf(discountCode));
//            statement.setString(2, description);
//            statement.setString(3, code);
//            statement.executeUpdate();
//        }

      //  throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает все записи таблицы PRODUCT_CODE в виде коллекции объектов
     * типа {@link ProductCode}
     * 
     * @param connection действительное соединение с базой данных
     * @return коллекция объектов типа {@link ProductCode}
     * @throws SQLException 
     */
    public static Collection<ProductCode> all(Connection connection) throws SQLException, IOException {
        try (PreparedStatement statement = getSelectQuery(connection)) {
                try (ResultSet result = statement.executeQuery()) {
                    return convert(result);
                }
        }
    }
}
