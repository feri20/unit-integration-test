package com.example.unit.proxy;

public class CachedImage implements Image{
    private String fileName;

    public CachedImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("the file name is :" + fileName);
    }
}
