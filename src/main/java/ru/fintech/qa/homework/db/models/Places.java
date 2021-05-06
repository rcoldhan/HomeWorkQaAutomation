package ru.fintech.qa.homework.db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public final class Places {
    @Id
    private int id;
    @Column(name = "\"row\"")
    private int row;
    @Column(name = "place_num")
    private int placeNum;
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(final int row) {
        this.row = row;
    }

    public int getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(final int placeNum) {
        this.placeNum = placeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}