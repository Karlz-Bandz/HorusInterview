package org.example.service.impl;

import org.example.service.Cabinet;
import org.example.service.Folder;
import org.example.service.MultiFolder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {

    private List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    private Stream<Folder> streamAllFolders(List<Folder> folders) {
        return folders.stream().flatMap(folder -> {
            if (folder instanceof MultiFolder multi) {
                return Stream.concat(Stream.of(multi), streamAllFolders(multi.getFolders()));
            } else {
                return Stream.of(folder);
            }
        });
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return streamAllFolders(folders)
                .filter(folder -> folder.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return streamAllFolders(folders)
                .filter(folder -> folder.getSize().equals(size))
                .toList();
    }

    @Override
    public int count() {
        return (int) streamAllFolders(folders).count();
    }
}
