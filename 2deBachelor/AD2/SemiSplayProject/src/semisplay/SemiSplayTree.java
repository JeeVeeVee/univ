package semisplay;

import java.util.ArrayList;
import java.util.Iterator;


public class SemiSplayTree implements SearchTree {

    private Boomtop root;
    private int splay;
    private int depth;
    private int size;


    public SemiSplayTree(int splay){
        this.splay = splay;
        this.depth = 0;
        this.size = 0;
    }

    /*
    geeft een de boomtop terug waarmee een bepaalde waarde corespondeert
     */
    public Boomtop zoektop(Comparable<Integer> integer){
        Comparable<Integer> test = null;
        Boomtop x = root;
        if (x.getWaarde() == integer){
            return x;
        }
        Boomtop prev = null;
        while (x != null && x != prev) {
            prev = x;
            x = x.getNextTop(integer);
            //System.out.println(test);
            test = prev.getWaarde();
        }
        return x;
    }

    /*
    verwisselt 2 toppen in de boom (alleen de toppen, de subbomen blijven onveranderd)
     */
    public void verwissel(Boomtop x, Boomtop y){
        Comparable<Integer> waardeX = x.getWaarde();
        Comparable<Integer> waardeY = y.getWaarde();
        y.setWaarde(waardeX);
        x.setWaarde(waardeY);
    }
    /*
    geeft de ouder terug van een bepaalde boomtop
     */
    public Boomtop getParent(Boomtop boomtop){
        Boomtop output = null;
        Comparable<Integer> integer = boomtop.getWaarde();
        Comparable<Integer> test = null;
        Boomtop x = root;
        Boomtop prev = null;
        if (x == prev){
            depth++;
            root = new Boomtop(integer);
            return root;
        }
        while (x != null && x != prev) {
            output = prev;
            prev = x;
            x = x.getNextTop(integer);
            System.out.println(test);
            test = prev.getWaarde();
        }
        return output;
    }

    @Override
    public boolean add(Comparable integer) {
        if(integer == null){
            return false;
        }
        int currentDepth = 0;
        Comparable<Integer> test = null;
        Boomtop x = root;
        Boomtop prev = null;
        if (x == prev){
            depth++;
            root = new Boomtop(integer);
            return true;
        }
        while (x != null && x != prev) {
            currentDepth ++;
            prev = x;
            x = x.getNextTop(integer);
            System.out.println(test);
            test = prev.getWaarde();
        }

        if (test.compareTo((Integer) integer) > 0){
            prev.setKleinerKind(new Boomtop(integer));
        } else if (test.compareTo((Integer) integer) < 0){
            prev.setGroterKind(new Boomtop(integer));
        }

        if (currentDepth + 1 > depth){
            depth = currentDepth + 1;
        }
        if (x == null){
            this.size++;
        }
        System.out.print("added ");
        System.out.println(integer);
        return x != null;

    }

    @Override
    public boolean contains(Comparable comparable) {
        Boomtop x = root;
        Boomtop prev = null;
        System.out.println((x.getWaarde()));
        while (x != null && x != prev) {
            prev = x;
            x = x.getNextTop(comparable);
            if (x != null) {
                System.out.println(x.getWaarde());
            }
        }
        if (x == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean remove(Comparable comparable) {
        boolean isKLeinerKind = true;
        Boomtop boomtop = zoektop(comparable);
        if(boomtop == null){
            return false;
        }
        Boomtop parent = getParent(boomtop);
        if (parent != null) {
            isKLeinerKind = parent.getWaarde().compareTo((Integer) boomtop.getWaarde()) > 1;
        }
        if (boomtop.getKleinerKind() == null && boomtop.getGroterKind() != null){
            if(isKLeinerKind){
                parent.setKleinerKind(boomtop.getGroterKind());
            } else {
                parent.setGroterKind(boomtop.getGroterKind());
            }
            return true;
        } else if (boomtop.getGroterKind() == null && boomtop.getKleinerKind() != null){
            if(isKLeinerKind){
                parent.setKleinerKind(boomtop.getKleinerKind());
            } else {
                parent.setGroterKind(boomtop.getKleinerKind());
            }
            return true;
        } else if(boomtop.getKleinerKind() == null && boomtop.getGroterKind() == null){
            if(isKLeinerKind){
                parent.setKleinerKind(null);
            } else {
                parent.setGroterKind(null);
            }
            return true;
        } else {
            Boomtop maxLinks = boomtop.getKleinerKind().getBiggest();
            Boomtop minRechts = boomtop.getGroterKind().getSmallest();
            if( (Integer) boomtop.getWaarde() - (Integer) maxLinks.getWaarde() < (Integer) minRechts.getWaarde() - (Integer) boomtop.getWaarde()){
                verwissel(boomtop, maxLinks);
            } else {
                verwissel(boomtop, minRechts);
            }
        } return remove(comparable);
    }

    public void splay(ArrayList<Boomtop> toppen){
        int teller = toppen.size() - 1;

    }
    /*
    geeft de wortel van onze boom terug
     */
    public Boomtop getRoot(){
        return this.root;
    }

    public int size() {
        return size;
    }

    public int depth() {
        return depth;
    }

    public Iterator iterator() {
        return null;
    }
}

