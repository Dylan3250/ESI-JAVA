package g54027.dev2.td06.jeu;

import java.util.Objects;

public class Personnage {

    private String name;
    private int hp;
    private boolean drunk;
    private boolean invisible;

    public Personnage(String name) {
        hp = 40;
        drunk = false;
        invisible = false;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isDrunk() {
        return drunk;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDrunk(boolean drunk) {
        this.drunk = drunk;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    @Override
    public String toString() {
        return "Personnage{" + "name=" + name + ", hp=" + hp + ", drunk="
                + drunk + ", invisible=" + invisible + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.hp;
        hash = 67 * hash + (this.drunk ? 1 : 0);
        hash = 67 * hash + (this.invisible ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personnage other = (Personnage) obj;
        if (this.hp != other.hp) {
            return false;
        }
        if (this.drunk != other.drunk) {
            return false;
        }
        if (this.invisible != other.invisible) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
}
