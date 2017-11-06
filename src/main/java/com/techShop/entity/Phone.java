package com.techShop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"title"})})
public class Phone {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String manufacturer;
    @NotNull
    private boolean isDigital;
    @Enumerated(EnumType.ORDINAL)
    private PhoneStatus status;
    @Enumerated(EnumType.ORDINAL)
    private PhoneMaterial material;
    @NotNull
    private double price;

    public Phone() {
    }

    public Phone(String title, String manufacturer, boolean isDigital, PhoneStatus status, PhoneMaterial material) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.isDigital = isDigital;
        this.status = status;
        this.material = material;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    public PhoneStatus getStatus() {
        return status;
    }

    public void setStatus(PhoneStatus status) {
        this.status = status;
    }

    public PhoneMaterial getMaterial() {
        return material;
    }

    public void setMaterial(PhoneMaterial material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
