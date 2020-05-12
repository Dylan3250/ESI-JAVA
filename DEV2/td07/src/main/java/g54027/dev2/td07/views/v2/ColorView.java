package g54027.dev2.td07.views.v2;

public class ColorView implements BlocView {

    public static void main(String[] args) {
        ColorView d = new ColorView();
        d.makeTitle("Titre");
        d.makeSubTitle("Sous-titre");
        d.makeParagraph("Ceci est un paragraphe");
        d.beginItemize();
        d.makeItem("Inteface View");
        d.makeItem("Class DecolorationView");
            d.beginItemize();
            d.makeItem("Item 1");
            d.makeItem("Item 2");
            d.endItemize();
        d.makeItem("Classe ColorView");
        d.makeItem("Classe HTMLView");
        d.endItemize();

        d.beginOrganisedItemize();
        d.makeItem("Inteface View");
        d.makeItem("Class DecolorationView");
        d.makeItem("Classe ColorView");
        d.makeItem("Classe HTMLView");
        d.endOrganisedItemize();
    }

    @Override
    public void makeTitle(String title) {
        System.out.println("\033[31m" + title + "\033[0m");
    }

    @Override
    public void makeSubTitle(String subtitle) {
        System.out.println("\033[32m" + subtitle + "\033[0m");
    }

    @Override
    public void makeItem(String sentence) {
        System.out.println("\t\033[33m- " + sentence + "\033[0m");
    }

    @Override
    public void makeParagraph(String paragraph) {
        System.out.println("\033[34m" + paragraph + "\033[0m");
    }
}