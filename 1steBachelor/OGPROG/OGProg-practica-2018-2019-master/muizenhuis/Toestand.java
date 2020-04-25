package muizenhuis;

public enum Toestand {

    BASIS {
        public Toestand linksAan(Kamers kamers) {
            return RECHTS_START;
        }

        public Toestand rechtsAan(Kamers kamers) {
            return LINKS_START;
        }

    },

    RECHTS_START {
        public Toestand linksUit(Kamers kamers) {
            return BASIS;
        }

        public Toestand rechtsAan(Kamers kamers) {
            return RECHTS_MIDDEN;
        }
    },

    RECHTS_MIDDEN {
        public Toestand rechtsUit(Kamers kamers) {
            return RECHTS_START;
        }

        @Override
        public Toestand linksUit(Kamers kamers) {
            return RECHTS_EINDE;
        }

    },

    RECHTS_EINDE {
        public Toestand linksAan(Kamers kamers) {
            return RECHTS_MIDDEN;
        }

        public Toestand rechtsUit(Kamers kamers) {
            kamers.vanLinksNaarRechts();
            return BASIS;
        }
    },

    LINKS_START {
        public Toestand rechtsUit(Kamers kamers) {
            return BASIS;
        }

        public Toestand linksAan(Kamers kamers) {
            return LINKS_MIDDEN;
        }
    },

    LINKS_MIDDEN {
        public Toestand linksUit(Kamers kamers) {
            return LINKS_START;
        }

        public Toestand rechtsUit(Kamers kamers) {
            return LINKS_EINDE;
        }
    },

    LINKS_EINDE {
        public Toestand rechtsAan(Kamers kamers) {
            return LINKS_MIDDEN;
        }

        public Toestand linksUit(Kamers kamers) {
            kamers.vanRechtsNaarLinks();
            return BASIS;
        }
    };

    Toestand linksAan(Kamers kamers) {
        return this;
    }
    Toestand linksUit(Kamers kamers) {
        return this;
    }

    Toestand rechtsAan(Kamers kamers) {
        return this;
    }

    Toestand rechtsUit(Kamers kamers) {
        return this;
    }
}
