package com.AbstractArt;

public class Painting extends Art {
    public String paintType;

    public Painting(String title, String author, String description, String paintType) {
        super(title, author, description);
        this.paintType = paintType;
    }

    public void viewArt(){
        String result = " ";
        result += "Title: " + getTitle() + "\n";
        result += "Author: "+getAuthor() + "\n";
        result += "Description: "+getDescription()+ "\n";
        result += "PaintType: " + paintType;
        System.out.println(result);
    }




    }


