package com.AbstractArt;

public class Sculpture extends Art{
    public String material;

    public Sculpture(String title, String author, String description, String material) {
        super(title, author, description);
        this.material = material;
    }
    public void viewArt(){
        String result = " ";
        result += "Title: " + getTitle() + "\n";
        result += "Author: "+getAuthor() + "\n";
        result += "Description: "+getDescription()+ "\n";
        result += "Material: " + material;
        System.out.println(result);
    }


}
