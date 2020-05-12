package g54027.dev2.td07.views.v2;

public class HTMLView implements BlocView {

    public static void main(String[] args) {
        HTMLView d = new HTMLView();
        d.makeTitle("Titre");
        d.makeSubTitle("Sous-titre");
        d.makeParagraph("Ceci est un paragraphe");
        d.beginItemize();
        d.makeItem("Inteface View");
        d.makeItem("Class DecolorationView");
        d.makeItem("Classe ColorView");
        d.beginItemize();
        d.makeItem("Item 1");
        d.makeItem("Item 2");
        d.beginItemize();
        d.makeItem("Item special 1");
        d.makeItem("Item special 2");
        d.makeItem("Item special 3");
        d.endItemize();
        d.makeItem("Item 3");
        d.endItemize();
        d.makeItem("Classe HTMLView");
        d.endItemize();
    }

    public int level = 0;

    @Override
    public void makeTitle(String title) {
        System.out.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeSubTitle(String subtitle) {
        System.out.println("<h2>" + subtitle + "</h2>");
    }

    @Override
    public void makeItem(String sentence) {
        if (level > 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");

            }
        }

        System.out.println("<li>" + sentence + "</li>");
    }

    @Override
    public void makeParagraph(String paragraph) {
        System.out.println("<p>" + paragraph + "</p>");
    }

    @Override
    public void beginItemize() {
        if (level > 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");

            }
            System.out.println("<li><ul>");
        } else {
            System.out.println("<ul>");
        }

        level++;
    }

    @Override
    public void endItemize() {
        level--;

        if (level > 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");

            }
            System.out.println("</ul></li>");
        } else {
            System.out.println("</ul>");
        }
    }
}
