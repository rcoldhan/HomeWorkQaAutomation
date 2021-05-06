package ru.fintech.qa.homework.db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "places")
public class Places {
    @Id
    int id;
    @Column(name = "\"row\"")
    int row;
    @Column (name = "place_num")
    int placeNum;
    @Column (name = "name")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(int placeNum) {
        this.placeNum = placeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Places{" +
                "id=" + id +
                ", row=" + row +
                ", placeNum=" + placeNum +
                ", name='" + name + '\'' +
                '}';
    }
}
