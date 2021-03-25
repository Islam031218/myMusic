package com.example.mymusic;

import java.util.ArrayList;

public class LocalDB {
    public static ArrayList<Order> arrayList = new ArrayList<>();

    public void addGood(Order order){
        arrayList.add(order);
    }

    public ArrayList<Order> getArrayList() {
        return arrayList;
    }

    public static void  removeGood(int position){
        arrayList.remove(arrayList.get(position));
    }


}
