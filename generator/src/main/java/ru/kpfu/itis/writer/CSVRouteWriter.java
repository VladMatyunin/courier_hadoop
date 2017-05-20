package ru.kpfu.itis.writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import ru.kpfu.itis.generator.RandomDateGenerator;
import ru.kpfu.itis.generator.RouteGenerator;
import ru.kpfu.itis.model.Route;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by vladislav on 19.05.17.
 */
class CSVRouteWriter{
    private static CSVRouteWriter writer;
    private CSVPrinter printer;
    private FileWriter fileWriter;
    private String[] fileHeader;
    private CSVRouteWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName,true);
        fileHeader = new String[]{"from","to","date"};
        printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT
//                .withHeader(fileHeader)
                .withRecordSeparator("\n"));
        printer.printRecord(fileHeader);
        printer.flush();
    }
    public static CSVRouteWriter getInstance(String fileName) throws IOException {
        if (writer==null) return new CSVRouteWriter(fileName);
        else return writer;
    }
    public void printRoute(Route route) throws IOException {
        printer.printRecord(route.getStringProperties());
        flush();
    }
    public void flush() throws IOException {
        printer.flush();
    }
    public void close() throws IOException {
        printer.close();
        fileWriter.close();

    }
}
