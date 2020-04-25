package semisplay;

public class Boomtop {
    private Boomtop kleinerKind;
    private Boomtop groterKind;
    private Comparable<Integer> waarde;

    public Boomtop(Comparable comparable){
        this.waarde = comparable;
        //kleinerKind = new Boomtop(null);
        //groterKind = new Boomtop(null);

    }

    public Boomtop getNextTop(Comparable<Integer> zoekterm){
        if(waarde.compareTo((Integer) zoekterm) > 0){
            return kleinerKind;
        } else if(waarde.compareTo((Integer) zoekterm) < 0){
            return groterKind;
        } else {
            return this;
        }
    }

    public void setKleinerKind(Boomtop boomtop){
        this.kleinerKind = boomtop;
    }

    public void setGroterKind(Boomtop boomtop){
        this.groterKind = boomtop;
    }

    public void setWaarde(Comparable<Integer> waarde) {
        this.waarde = waarde;
    }

    public Comparable<Integer> getWaarde(){
        return this.waarde;
    }

    public Boomtop getKleinerKind(){
        return this.kleinerKind;
    }

    public Boomtop getGroterKind(){
        return this.groterKind;
    }

    public Boomtop getBiggest(){
        if(this.getGroterKind() == null){
            return this;
        }
        //System.out.println(this.getWaarde());
        return this.getGroterKind().getBiggest();
    }

    public Boomtop getSmallest(){
        if (this.getKleinerKind() == null){d-
            return this;
        }
        return this.getKleinerKind().getSmallest();
    }
}
