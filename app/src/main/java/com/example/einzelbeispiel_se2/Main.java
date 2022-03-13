package com.example.einzelbeispiel_se2;

public class Main implements Runnable{
    @Override
    public void run() {
        try{
            new View();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
