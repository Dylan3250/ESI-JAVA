package g54027.dev2.td07.views.v1;

public class DecoratorView implements View {

    public static void main(String[] args) {
        DecoratorView d = new DecoratorView();
        d.makeTitle("Titre");
        d.makeSubTitle("Sous-titre");
        d.makeParagraph("Ceci est un paragraphe");
        d.makeItem("Inteface View");
        d.makeItem("Class DecolorationView");
        d.makeItem("Classe ColorView");
        d.makeItem("Classe HTMLView");
    }

    @Override
    public void makeTitle(String title) {
        var str = new StringBuilder();
        int space = 5;

        // Top border
        str.append("|");
        str.append("-".repeat(title.length() + space * 2));
        str.append("|\n|");

        // Body
        str.append(" ".repeat(space));
        str.append(title);
        str.append(" ".repeat(space));
        str.append("|\n|");

        // Bottom border
        str.append("-".repeat(title.length() + space * 2));
        str.append("|");

        System.out.println(str);
    }

    @Override
    public void makeSubTitle(String subtitle) {
        var str = new StringBuilder(subtitle).append("\n");
        str.append("-".repeat(subtitle.length()));
        System.out.println(str);
    }

    @Override
    public void makeItem(String sentence) {
        System.out.println("\t* " + sentence);
    }

    @Override
    public void makeParagraph(String paragraph) {
        System.out.println(paragraph);
    }
}
