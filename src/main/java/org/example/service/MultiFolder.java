package org.example.service;

import java.util.List;

public interface MultiFolder extends Folder {
    List<Folder> getFolders();
}
