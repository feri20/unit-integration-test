package com.example.unit.proxy;

public class ProxyImage implements Image{

    private String fileName;
    private RealImage realImage;
    private CachedImage cachedImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage==null){
            realImage = new RealImage(fileName);
        }else if(cachedImage==null){
            cachedImage = new CachedImage(fileName);
            cachedImage.display();
        }
        realImage.display();
    }
}
