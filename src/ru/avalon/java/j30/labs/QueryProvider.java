package ru.avalon.java.j30.labs;

import java.io.*;

public class QueryProvider {

    public String getQuery(String path) throws IOException {
        path = "resourses/sql/" + path + ".sql";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream(path);
             Reader reader = new InputStreamReader(stream);
             BufferedReader in = new BufferedReader(reader)){
             StringBuilder builder = new StringBuilder();
             String line;
             while ((line = in.readLine()) != null){
                 builder.append(line)
                        .append(System.lineSeparator());
            }
            return builder.toString();
        }
    }
}
