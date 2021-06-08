package esi.atl.g54027.td07.composite;

public class FileSystemLeaf extends FileSystemComponent {

    private final long size;

    public FileSystemLeaf(String cName, long sz) {
        super(cName);
        size = sz;
    }

    @Override
    public long getSize() {
        return size;
    }

}
