package com.company.entities;

public class Train {
    private int id;
    private String name;
    private int capacity;

    public Train(){

    }
    public Train(int id,String name,int capacity){
       setId(id);
       setName(name);
       setCapacity(capacity);
    }
    public Train(String name,int capacity){
        setName(name);
        setCapacity(capacity);
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int totalCapacity) {
        this.capacity = totalCapacity;
    }
    @Override
    public String toString(){
        return "Train: "+name+". Capacity:"+capacity;
    }

}
