import org.example.service.Folder;
import org.example.service.impl.ComplexFolder;
import org.example.service.impl.FileCabinet;
import org.example.service.impl.SimpleFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileCabinetTest {

    private FileCabinet fileCabinet;

    @BeforeEach
    void setUp() {
        Folder folder1 = new SimpleFolder("Folder1", "MEDIUM");
        Folder folder2 = new ComplexFolder("Folder2", "LARGE", List.of(
                new SimpleFolder("SubFolder1", "SMALL"),
                new SimpleFolder("SubFolder2", "SMALL")
        ));
        Folder folder3 = new SimpleFolder("Folder3", "SMALL");

        List<Folder> folders = List.of(folder1, folder2, folder3);
        fileCabinet = new FileCabinet(folders);
    }

    @Test
    void findFolderByNameTest() {
        Optional<Folder> foundFolder = fileCabinet.findFolderByName("Folder3");

        assertTrue(foundFolder.isPresent());
        assertEquals("SMALL", foundFolder.get().getSize());
    }

    @Test
    void findFoldersBySizeTest() {
        List<Folder> foundFolders = fileCabinet.findFoldersBySize("SMALL");
        assertEquals(3, foundFolders.size());
    }

    @Test
    void countTest() {
        assertEquals(5, fileCabinet.count());
    }
}
