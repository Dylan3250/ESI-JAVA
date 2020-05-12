package g54027.dev2.td06.jeu;

public enum Potions {
    
    POISON {
        @Override
        public void consumedBy(Personnage personnage) {
            personnage.setHp(0);
        }
    ;
    }, INVISIBILITY {
        @Override
        public void consumedBy(Personnage personnage) {
            personnage.setInvisible(true);
        }
    ;
    }, ALCOOL {
        @Override
        public void consumedBy(Personnage personnage) {
            personnage.setDrunk(true);
        }
    ;};

    public abstract void consumedBy(Personnage personnage);
}
