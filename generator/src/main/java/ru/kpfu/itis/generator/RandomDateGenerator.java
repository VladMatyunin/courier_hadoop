package ru.kpfu.itis.generator;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by vladislav on 19.05.17.
 */
public class RandomDateGenerator {
    private long beginTime;
    private long endTime;
    public RandomDateGenerator(){
        beginTime = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
        endTime = Timestamp.valueOf("2015-12-31 00:58:00").getTime();
    }
    public Date getRandomDate(){
        long diff = endTime - beginTime + 1;
        return new Date(beginTime + (long) (Math.random() * diff));
    }
}
