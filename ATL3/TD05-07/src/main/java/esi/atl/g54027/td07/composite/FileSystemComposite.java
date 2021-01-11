package esi.atl.g54027.td07.composite;

import java.util.ArrayList;
import java.util.List;

public class FileSystemComposite extends FileSystemComponent {

    List<FileSystemComponent> fsComponents;

    public FileSystemComposite(String name) {
        super(name);
        this.fsComponents = new ArrayList<>();
    }

    @Override
    public long getSize() {
        long size = 0;
        for (FileSystemComponent fsCompo : fsComponents) {
            size = size + (fsCompo.getSize());
        }
        return size;
    }

    public void add(FileSystemComponent shape) {
        fsComponents.add(shape);
    }

    public void remove(FileSystemComponent shape) {
        fsComponents.remove(shape);
    }

    public List<FileSystemComponent> getChildren() {
        return fsComponents;
    }
}
