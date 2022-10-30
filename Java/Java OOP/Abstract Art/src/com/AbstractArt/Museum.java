package com.AbstractArt;

public class Museum {
    public static void main(String[] args) {
    Painting art =new Painting("Amin","Sura", "Easy", "oil");
    Painting art1 =new Painting("Hala","Sura", "Easy", "oil");
    Painting art2 =new Painting("Tareq","Sura", "Easy", "oil");
    Sculpture sculpture = new Sculpture("Dark", "Blue", "Hard", "Marble");
    Sculpture sculpture1 = new Sculpture("Lox", "Rrd", "Hard", "Marble");
        art.viewArt();
        art1.viewArt();
        art2.viewArt();
        sculpture.viewArt();
        sculpture1.viewArt();
    }
}
