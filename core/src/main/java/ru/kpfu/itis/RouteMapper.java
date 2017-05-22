package ru.kpfu.itis;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/**
 * Created by vladislav on 19.05.17.
 */
public class RouteMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split(",");
        String cityFrom = line[0];
        if (cityFrom.startsWith("from")) return;
        String year = line[2].substring(0,4);
        context.write(new Text("< "+cityFrom+" "+year), new IntWritable(1));
        context.write(new Text("> "+cityFrom+" "+year), new IntWritable(1));
    }
}
