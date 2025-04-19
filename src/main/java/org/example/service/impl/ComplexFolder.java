package org.example.service.impl;

import org.example.service.Folder;
import org.example.service.MultiFolder;

import java.util.List;

public class ComplexFolder extends SimpleFolder implements MultiFolder {

    private final List<Folder> folders;

    public ComplexFolder(String name, String size, List<Folder> folders) {
        super(name, size);
        this.folders = folders;
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }
}
