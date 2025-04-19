package org.example.service.impl;

import org.example.service.Folder;

public class SimpleFolder implements Folder {

    private String name;
    private String size;

    public SimpleFolder(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }
}
