import semisplay.SemiSplayTree;

public class Main {
    public static void main (String[] args){

        SemiSplayTree boom = new SemiSplayTree(3);
        boom.add(10);
        boom.add(5);
        boom.add(15);
        boom.add(3);
        boom.add(2);
        boom.add(1);
        boom.add(7);
        boom.add(12);
        boom.add(18);
        boom.add(19);
        boom.add(17);
        boom.add(16);
        boom.add(6);
        boom.add(8);
        boom.add(9);
        //System.out.println(" ");
        boom.remove(10);
        System.out.println(boom.getRoot().getWaarde());
        //System.out.println(boom.depth());

      }
}
