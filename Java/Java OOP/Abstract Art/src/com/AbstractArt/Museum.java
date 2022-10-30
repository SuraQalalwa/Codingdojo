package com.AbstractArt;

public class Museum {
    public static void main(String[] args) {
    Painting art =new Painting("Amin","Sura", "Easy", "oil");
    Sculpture sculpture = new Sculpture("Dark", "Blue", "Hard", "Marble");
        art.viewArt();
        sculpture.viewArt();
    }
}
