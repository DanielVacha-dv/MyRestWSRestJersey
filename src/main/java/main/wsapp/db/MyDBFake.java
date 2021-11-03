package main.wsapp.db;


import main.wsapp.models.Library;

public class MyDBFake {
    private static Library dbFake = new Library();

    public static Library getDbFake() {
        return dbFake;
    }
}
