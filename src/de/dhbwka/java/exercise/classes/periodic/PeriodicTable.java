package de.dhbwka.java.exercise.classes.periodic;

public class PeriodicTable {
    
    Element[] pt = new Element[118];

    public static void main(String[] args) {
        PeriodicTable pt = new PeriodicTable();
        Element h = new Element("Hydrogen", "H", 1, 'K', 3, true);
        pt.addElement(h);
        pt.addElement(new Element("Helium", "He", 2, 'K', 3, true));
        Element na = new Metal("Sodium", "Na", 11, 'M', 1, true, false, 21000000);
        pt.addElement(na);
        pt.addElement(new Metal("Iron", "Fe", 26, 'N', 1, false, false, 10020000));
        pt.addElement(new Metal("Germanium", "Ge", 32, 'N', 1, false, true, 1.45));
        pt.addElement(new Element("Bromine", "Br", 35, 'N', 2, true));
        pt.addElement(new Metal("Tellurium", "Te", 52, 'O', 1, true, true, 0.005));
        pt.addElement(new Metal("Gold", "Au", 79, 'P', 1, false, false, 44000000));
        System.out.println(h);
        System.out.println(pt.getElement(2));
        System.out.println(na);
        Element[] metals = pt.getMetals();
        System.out.println("Metals:");
        for (int i = 0; i < metals.length; i++) {
            System.out.println(metals[i]);
        }
        System.out.println("Gold:");
        System.out.println(pt.getElement(79));
    }

    public void addElement(Element e){
        pt[e.getOrdinal() - 1] = e;
    }
    public boolean hasElement(int o){
        return pt[o-1] == null ? false : true;
    }
    public Element getElement(int o){
        return pt[o-1];
    }
    public Element[] getMetals(){
        int m = 0;
        for (int i = 0; i < pt.length; i++) {
            if(pt[i] instanceof Metal){
                m++;
            }
        }
        Element[] metals = new Element[m];
        for (int i = 0; i < pt.length; i++) {
            if(pt[i] instanceof Metal){
                metals[metals.length - m--] = pt[i];
            }
        }
        return metals;
    }
}