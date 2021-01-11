package esi.atl.g54027.td07.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aro
 */
public class CompositeDP {

    public static void main(String[] args) {
        FileSystemComposite mainFolder = new FileSystemComposite("mainFolder");
        FileSystemComposite subFolder1 = new FileSystemComposite("subFolder1");
        FileSystemComposite subFolder2 = new FileSystemComposite("subFolder2");

        mainFolder.add(subFolder1);
        mainFolder.add(subFolder2);
        subFolder1.add(new FileSystemLeaf("file11.txt", 1000));
        subFolder1.add(new FileSystemLeaf("file12.txt", 2000));
        subFolder2.add(new FileSystemLeaf("file21.txt", 3000));
        FileSystemLeaf file22 = new FileSystemLeaf("file22.txt", 4000);
        subFolder2.add(file22);
        
        List<FileSystemComponent> fsListToPrint = new ArrayList<>();
        fsListToPrint.add(mainFolder);
        fsListToPrint.add(subFolder1);
        fsListToPrint.add(file22);
        for (FileSystemComponent fsCompo : fsListToPrint) {
            System.out.println(fsCompo);
        }
    }
 }
