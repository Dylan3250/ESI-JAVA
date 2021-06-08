package esi.atl.g54027.repository.dto;

import java.util.Objects;

public class Dto<K> {

    protected K key;

    protected Dto(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Clé null");
        }
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.key);
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
        final Dto<?> other = (Dto<?>) obj;
        return Objects.equals(this.key, other.key);
    }

}
