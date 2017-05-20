package ru.kpfu.itis.writer;

import ru.kpfu.itis.generator.RouteGenerator;

import java.io.IOException;

/**
 * Created by vladislav on 19.05.17.
 */
public class DataBuilder {

    private RouteGenerator generator;
    private String path;
    public DataBuilder(String file){
        path = file;
        generator = new RouteGenerator();
    }
    public void start(int iterations){
        try {
        CSVRouteWriter printer = CSVRouteWriter.getInstance(path);

            for (int i = 0; i < iterations; i++) {

                        printer.printRoute(generator.createRandomRoute());
            }
            printer.close();
        }catch (IOException e){
            //TODO: delete file and exit with code
        }
    }
}
