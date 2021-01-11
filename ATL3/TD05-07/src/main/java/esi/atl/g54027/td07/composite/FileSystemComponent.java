package esi.atl.g54027.td07.composite;

public abstract class FileSystemComponent {

    String name;

    public FileSystemComponent(String cName) {
        name = cName;
    }

    public String getName() {
        return name;
    }

    public abstract long getSize();

    @Override
    public String toString() {
        return name + ", size=" + getSize();
    }
    
}
