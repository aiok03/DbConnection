package com.company.entities;

public class Locomative {
    private int id;
    private String name;
    private int trainId;
    public Locomative(){

    }
    public Locomative(int id,String name,int trainId){
    setId(id);
    setName(name);
    setTrainId(trainId);
    }
    public Locomative(String name,int trainId){
        setName(name);
        setTrainId(trainId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
}
