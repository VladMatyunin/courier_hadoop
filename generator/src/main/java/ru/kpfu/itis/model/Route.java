package ru.kpfu.itis.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vladislav on 19.05.17.
 */
public class Route {
    private City from;
    private City to;
    private Date date;

    public Route(City from, City to, Date date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String[] getStringProperties(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new String[]{from.getName(),to.getName(),format.format(date)};
    }

}
