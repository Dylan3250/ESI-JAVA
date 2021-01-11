package esi.atl.g54027.td01;

public enum Direction {
    NORTH('N', "North"), SOUTH('S', "South"), WEST('W', "West"), EAST('E', "East");
    private char c;
    private String str;

    Direction(char c, String str) {
        this.c = c;
        this.str = str;
    }

    public char getChar() {
        return c;
    }

    @Override
    public String toString() {
        return str;
    }
}

class testDirection {
    public static void main(String[] args) {
        for(Direction d : Direction.values()){
            System.out.println(d);
        }
    }
}