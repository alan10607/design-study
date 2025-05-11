package com.alan.design.structural.composite_pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CompositePatternTest {

    @Test
    void testFileAndFolderOperation() {
        FileNode file1 = new FileNode("File1.txt");
        FileNode file2 = new FileNode("File2.txt");
        FileNode file3 = new FileNode("File3.txt");

        FolderNode folder1 = new FolderNode("Folder1");
        FolderNode folder2 = new FolderNode("Folder2");
        FolderNode folder3 = new FolderNode("Folder3");

        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        folder3.add(folder1);
        folder3.add(folder2);


        assertThrows(UnsupportedOperationException.class, () -> file1.add(file2), "File cannot add children");
        assertThrows(UnsupportedOperationException.class, () -> file1.remove(file2), "File cannot remove children");

        assertEquals(folder3.getChildren().size(), 2);
        assertTrue(folder3.getChildren().contains(folder1));
        assertTrue(folder3.getChildren().contains(folder2));

        assertEquals(folder2.getChildren().size(), 1);
        assertTrue(folder2.getChildren().contains(file3));

        assertEquals(folder1.getChildren().size(), 2);
        assertTrue(folder1.getChildren().contains(file1));
        assertTrue(folder1.getChildren().contains(file2));

        assertEquals(file1.getChildren().size(), 0);
        assertEquals(file2.getChildren().size(), 0);
        assertEquals(file3.getChildren().size(), 0);
        log.info("Node tree: {}", folder3);

        // test remove node
        folder1.remove(file2);
        assertEquals(folder1.getChildren().size(), 1);
        assertTrue(folder1.getChildren().contains(file1));
        assertFalse(folder1.getChildren().contains(file2));
        log.info("Node tree: {}", folder3);

        folder3.remove(folder2);
        assertEquals(folder3.getChildren().size(), 1);
        assertTrue(folder3.getChildren().contains(folder1));
        assertFalse(folder3.getChildren().contains(folder2));
        log.info("Node tree: {}", folder3);
    }
}