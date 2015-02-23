package sample.items;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Instrument {

    private final StringProperty symbol = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final DoubleProperty lastPrice = new SimpleDoubleProperty();
    private final DoubleProperty openPrice = new SimpleDoubleProperty();
    private final DoubleProperty lowPrice = new SimpleDoubleProperty();
    private final DoubleProperty highPrice = new SimpleDoubleProperty();


    public Instrument(String symbol, double lastPrice) {
        this.symbol.set(symbol);
        this.status.set("Open");
        this.lastPrice.set(lastPrice);
    }

    public String getSymbol() {
        return symbol.get();
    }

    public StringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public double getLastPrice() {
        return lastPrice.get();
    }

    public DoubleProperty lastPriceProperty() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice.set(lastPrice);
    }

    public double getOpenPrice() {
        return openPrice.get();
    }

    public DoubleProperty openPriceProperty() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice.set(openPrice);
    }

    public double getLowPrice() {
        return lowPrice.get();
    }

    public DoubleProperty lowPriceProperty() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice.set(lowPrice);
    }

    public double getHighPrice() {
        return highPrice.get();
    }

    public DoubleProperty highPriceProperty() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice.set(highPrice);
    }
}
