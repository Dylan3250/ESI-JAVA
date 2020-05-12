package g54027.dev2.td07.views.v2;

public interface BlocView extends View {
    
    public default void beginItemize() {
        System.out.println();
    }

    public default void endItemize() {
        System.out.println();
    }

    public default void beginOrganisedItemize() {
        System.out.println();
    }

    public default void endOrganisedItemize() {
        System.out.println();
    }
}