package ru.kpfu.itis;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by vladislav on 19.05.17.
 */
public class RouteReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum=0;
        String[] lines = key.toString().split(" ");
        if (lines[0].equals("from")) return;
        String direction = lines[0];
        String city = lines[1];
        String year = lines[2];
        while (values.iterator().hasNext()){
            values.iterator().next();
            sum++;
        }
        context.write(key,new IntWritable(sum));
    }
}
