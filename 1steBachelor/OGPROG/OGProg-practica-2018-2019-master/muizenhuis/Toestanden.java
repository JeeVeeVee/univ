package muizenhuis;

/**
 * Alle mogelijke toestanden
 */
public class Toestanden {

    /**
     * Gemeenschappelijke bovenklasse van de verschillende toestanden. Doet niets bij elke sensorverandering
     */
    private static class AbstractToestand implements Toestand {
        @Override
        public Toestand linksAan(Kamers kamers) {
            return this;
        }

        @Override
        public Toestand linksUit(Kamers kamers) {
            return this;
        }

        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return this;
        }

        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return this;
        }
    }

    public static class Basis extends AbstractToestand {

        @Override
        public Toestand linksAan(Kamers kamers) {
            return new RechtsStart();
        }

        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return new LinksStart();
        }
    }

    public static class RechtsStart extends AbstractToestand {

        @Override
        public Toestand linksUit(Kamers kamers) {
            return new Basis();
        }

        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return new RechtsMidden();
        }
    }

    public static class RechtsMidden extends AbstractToestand {

        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return new RechtsStart();
        }

        @Override
        public Toestand linksUit(Kamers kamers) {
            return new RechtsEinde();
        }
    }


    public static class RechtsEinde extends AbstractToestand {
        @Override
        public Toestand linksAan(Kamers kamers) {
            return new RechtsMidden();
        }

        @Override
        public Toestand rechtsUit(Kamers kamers) {
            kamers.vanLinksNaarRechts();
            return new Basis();
        }
    }

    public static class LinksStart extends AbstractToestand {

        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return new Basis();
        }

        @Override
        public Toestand linksAan(Kamers kamers) {
            return new LinksMidden();
        }
    }

    public static class LinksMidden extends AbstractToestand {

        @Override
        public Toestand linksUit(Kamers kamers) {
            return new LinksStart();
        }

        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return new LinksEinde();
        }
    }

    public static class LinksEinde extends AbstractToestand {
        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return new LinksMidden();
        }

        @Override
        public Toestand linksUit(Kamers kamers) {
            kamers.vanRechtsNaarLinks();
            return new Basis();
        }
    }



}
