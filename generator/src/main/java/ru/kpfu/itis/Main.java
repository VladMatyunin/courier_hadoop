package ru.kpfu.itis;

import ru.kpfu.itis.writer.DataBuilder;

/**
 * Created by vladislav on 19.05.17.
 */
public class Main {
    public static void main(String[] args){
        if (args.length<2){
            System.err.print("Write result path");
            System.exit(-1);
        }
        DataBuilder builder = new DataBuilder(args[0]);
        builder.start(Integer.parseInt(args[1]));
    }
}
