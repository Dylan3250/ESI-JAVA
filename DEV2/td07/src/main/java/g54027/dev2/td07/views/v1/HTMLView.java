package g54027.dev2.td07.views.v1;

public class HTMLView implements View, BlocView {

    public static void main(String[] args) {
        HTMLView d = new HTMLView();
        d.makeTitle("Titre");
        d.makeSubTitle("Sous-titre");
        d.makeParagraph("Ceci est un paragraphe");
        d.beginItemize();
        d.makeItem("Inteface View");
        d.makeItem("Class DecolorationView");
        d.makeItem("Class DecolorationView");
        d.makeItem("Classe ColorView");
        d.makeItem("Classe HTMLView");
        d.endItemize();
    }

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
        System.out.println("\t<li>" + sentence + "</li>");
    }

    @Override
    public void makeParagraph(String paragraph) {
        System.out.println("<p>" + paragraph + "</p>");
    }

    @Override
    public void beginItemize() {
        System.out.println("<ul>");
    }

    @Override
    public void endItemize() {
        System.out.println("</ul>");
    }
}
