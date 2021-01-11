package esi.alg.g54027.list;

public class Main {

    public static void main(String[] args) {
//        --- LISTE CHAINEE
//        ListeChainee<Integer> listInt = new ListeChainee<>();
//        listInt.insererTete(4);
//        listInt.insererTete(5);
//        ElementList<Integer> insertApres = listInt.getPremier();
//        listInt.insererAprès(insertApres, 5455445);
//        listInt.insererTete(44);
//        listInt.insererTete(144);
//        System.out.println("Taille : " + listInt.size());
//        System.out.println(listInt);

//        --- LISTE BIDIRECTIONNELLE
        ListeBD<Integer> listBDInt = new ListeBD<>();
        listBDInt.insererTete(10);
        ElementListeBD<Integer> insertApres = listBDInt.getPremier();
        listBDInt.insererApres(insertApres, 101010);
        listBDInt.insererTete(425);
        ElementListeBD<Integer> insertAvant = listBDInt.getPremier();
        listBDInt.insererAvant(insertAvant, 1000);
        System.out.println(listBDInt);
        listBDInt.supprimerTête();
        System.out.println(listBDInt);
        listBDInt.supprimerFin();
        System.out.println(listBDInt);
        listBDInt.insererTete(900);
        listBDInt.insererTete(700);
        listBDInt.insererFin(77);
        listBDInt.insererTete(500);
        listBDInt.insererTete(300);
        System.out.println(listBDInt);
        listBDInt.supprimer(listBDInt.getPremier().getSuivant());
        System.out.println(listBDInt);
    }
}
