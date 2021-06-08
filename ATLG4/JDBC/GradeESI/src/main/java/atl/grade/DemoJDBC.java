package atl.grade;

import atl.grade.change.DemoDelete;
import atl.grade.change.DemoInsert;
import atl.grade.change.DemoUpdate;
import atl.grade.config.ConfigManager;
import atl.grade.date.DemoDateSelect;
import atl.grade.injection.DemoInjection;
import atl.grade.injection.DemoInjectionBis;
import atl.grade.prepare.DemoPrepare;
import atl.grade.selection.DemoSelect;
import atl.grade.selection.DemoSelectAll;
import atl.grade.selection.SelectAllLessons;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jlc
 */
public class DemoJDBC {

    /**
     * Entry points to the <code> Mentoring </code> application.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        try {
            ConfigManager.getInstance().load();
            String dbUrl = ConfigManager.getInstance().getProperties("db.url");
            System.out.println("Base de données stockée : " + dbUrl);

//            Demo demo = new DemoSelectAll();
//            demo.printTitle();
//            demo.execute(dbUrl);
//            
//            Demo lessons = new SelectAllLessons();
//            lessons.printTitle();
//            lessons.execute(dbUrl);
//
//            Demo demo = new DemoSelect();
//            demo.printTitle();
//            demo.execute(dbUrl);
//
//            Demo demo = new DemoUpdate();
//            demo.printTitle();
//            demo.execute(dbUrl);
//
//            Demo demo = new DemoInsert();
//            demo.printTitle();
//            demo.execute(dbUrl);
//
//            Demo demo = new DemoDelete();
//            demo.printTitle();
//            demo.execute(dbUrl);
//
//            Demo ex02 = new Ex02();
//            ex02.execute(dbUrl);
//
//            Demo demo = new DemoDateSelect();
//            demo.printTitle();
//            demo.execute(dbUrl);
//
//            Demo ex03 = new Ex03();
//            ex03.printTitle();
//            ex03.execute(dbUrl);          
//   
//          UPDATE STUDENTS SET firstname="Patrick",lastName="Star" where id="1"
//          UPDATE STUDENTS SET firstname="Patrick",lastName="Star" where id=1;DELETE FROM GRADES
//            System.out.println("Base de données stockée : " + dbUrl);
//            System.out.println("Entrez votre requête ");
//            Scanner input = new Scanner(System.in);
//            String query = input.nextLine();
//            Demo demo = new DemoInjection(query);
//            demo.printTitle();
//            demo.execute(dbUrl);
//
//          ID : 1 LASTNAME : Ols
//          ID : 1 LASTNAME : A' OR id > 0 --
//            System.out.println("Base de données stockée : " + dbUrl);
//            Scanner input = new Scanner(System.in);
//            System.out.println("Id : ");
//            int id = input.nextInt();
//            input.nextLine();
//            System.out.println("Lastname : ");
//            String lastname = input.nextLine();
//            Demo demo = new DemoInjectionBis(dbUrl, id, lastname);
//            demo.printTitle();
//            demo.execute(dbUrl);

//          ID : 1 LASTNAME : Ols
//          ID : 1 LASTNAME : A' OR id > 0 --
//            System.out.println("Base de données stockée : " + dbUrl);
//            Scanner input = new Scanner(System.in);
//            System.out.println("Id : ");
//            int id = input.nextInt();
//            input.nextLine();
//            System.out.println("Lastname : ");
//            String lastname = input.nextLine();
//            Demo demo = new DemoPrepare(dbUrl, id, lastname);
//            demo.printTitle();
//            demo.execute(dbUrl);
        } catch (IOException ex) {
            System.out.println("Erreur IO " + ex.getMessage());
        }
    }

    private DemoJDBC() {

    }
}
