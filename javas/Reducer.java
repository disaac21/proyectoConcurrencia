package org.wordcounter;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.jetbrains.annotations.NotNull;

public class Reducer extends MapReduceBase implements org.apache.hadoop.mapred.Reducer<Text,IntWritable,Text,IntWritable> {
    public void reduce(Text key, @NotNull Iterator<IntWritable> values, OutputCollector<Text,IntWritable> output,
                       Reporter reporter) throws IOException {
        int sum=0;
        while (values.hasNext()) {
            sum+=values.next().get();
        }
        if(sum>5000){
            output.collect(key,new IntWritable(sum));

        }

    }
}