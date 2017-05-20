package ru.kpfu.itis;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

/**
 * Created by vladislav on 19.05.17.
 */
public class MainStarter {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        if (args.length!=2) {
            System.err.println("Usage: <input_path> <output_path>");
            System.exit(-1);
        }
        try {
//            Configuration configuration = new Configuration();
            Job job = new Job();
            job.setJarByClass(MainStarter.class);
            job.setJobName("Router");
            FileInputFormat.addInputPath(job,new Path(args[0]));
            FileOutputFormat.setOutputPath(job,new Path(args[1]));
            job.setMapperClass(RouteMapper.class);
            job.setReducerClass(RouteReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            System.exit(job.waitForCompletion(true)?0:1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
