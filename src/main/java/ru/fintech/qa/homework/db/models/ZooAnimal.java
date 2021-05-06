package ru.fintech.qa.homework.db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table (name = "zoo_animal")
public class ZooAnimal {
    @Column (name = "zoo_id")
    int zooId;
    @Column (name = "animal_id")
    int animalId;
    @Column (name = "time_apperance")
    Timestamp time;
    @Column (name = "workman")
    int workmanId;

    public int getId() {
        return zooId;
    }

    public void setId(int id) {
        this.zooId = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getWorkmanId() {
        return workmanId;
    }

    public void setWorkmanId(int workmanId) {
        this.workmanId = workmanId;
    }
}
