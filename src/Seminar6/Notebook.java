package Seminar6;

import java.util.Comparator;

class NameCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.name.compareTo(o2.name);
    }
}

class ProcessorCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.processor.compareTo(o2.processor);
    }
}
//    Integer RAMGB;
class RAMCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        if(o1.RAMGB > o2.RAMGB) return 1;
        else return -1;
    }
}
//    Integer HDDGB;
class HDDCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        if(o1.HDDGB > o2.HDDGB) return 1;
        else return -1;
    }
}
//    String operatingSystem;
class OSCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.operatingSystem.compareTo(o2.operatingSystem);
    }
}
//    String color;
class ColorCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.color.compareTo(o2.color);
    }
}
//    Integer price;
class PriceCompare implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        if(o1.price > o2.price) return -1;
        else return 1;
    }
}

public class Notebook {
//    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//5.6" Ноутбук ASUS X515EA-BQ1185W 1920x1080, Intel Core i5 1135G7 2.4 ГГц,
// RAM 8 ГБ, SSD 512 ГБ, Intel Iris Xe Graphics, Windows 11 Home, 90NB0TY1-M00KM0, серый
    String name;
    String manufacturer;
    String processor;
    Integer RAMGB;
    Integer HDDGB;
    String operatingSystem;
    String color;
    Integer price;
    Notebook(String name, String manufacturer, String processor, Integer RAMGB,
             Integer HDDGB, String operatingSystem, String color, Integer price){
        this.name = name;
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.RAMGB = RAMGB;
        this.HDDGB = HDDGB;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.price = price;
    }
    Notebook(){
        this.name = null;
        this.manufacturer = null;
        this.processor = null;
        this.RAMGB = 0;
        this.HDDGB = 0;
        this.operatingSystem = null;
        this.color = null;
        this.price = 0;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.manufacturer + " | " + this.processor + " | " +
                this.RAMGB + " GB. | " + this.HDDGB + " GB. | " + this.operatingSystem + " | " +
                this.color + " | " + this.price;
    }
}
