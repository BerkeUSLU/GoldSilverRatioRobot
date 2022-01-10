package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class RatioData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    private long timestamp;
    private String metal;
    private String exchange;
    private String currency;
    private double price;
    private double prev_close_price;
    private double ch;
    private double chp;

    public RatioData() {

    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrev_close_price() {
        return prev_close_price;
    }

    public void setPrev_close_price(double prev_close_price) {
        this.prev_close_price = prev_close_price;
    }

    public double getCh() {
        return ch;
    }

    public void setCh(double ch) {
        this.ch = ch;
    }

    public double getChp() {
        return chp;
    }

    public void setChp(double chp) {
        this.chp = chp;
    }

    @Override
    public String toString() {
        return "RatioData{" +
                "date=" + timestamp +
                ", metal='" + metal + '\'' +
                ", exchange='" + exchange + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", prev_close_price=" + prev_close_price +
                ", ch=" + ch +
                ", chp=" + chp +
                '}';
    }
}
