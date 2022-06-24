package com.meow.testanime.ModelsManga;

import java.io.Serializable;
import java.util.Date;

public class Published implements Serializable {
    private Date from;
    private Date to;
    private Prop prop;
    private String String;

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }
}
