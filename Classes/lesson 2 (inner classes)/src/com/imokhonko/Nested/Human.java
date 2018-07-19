package com.imokhonko.Nested;

public class Human {

    private final String name;
    private final int age;
    private Relations relations;


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.relations = null;
    }

    public boolean setRelations(final Relations.RelationTypes relationType, final Human withWho) {
        this.relations = new Human.Relations (relationType, withWho);
        return true;
    }

    public boolean setRelations(final Relations.RelationTypes relationType) {
        this.relations = new Human.Relations (relationType);
        return true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Relations getRelations() {
        return relations;
    }


    static public class Relations {

        private final RelationTypes relationType;
        private final Human withWho;

        public Relations(final RelationTypes relationType) {
            this(relationType, null);
        }

        public Relations(final RelationTypes relationType, final Human withWho) {
            this.relationType = relationType;
            this.withWho = relationType.isAllowed () ? withWho : null;
        }

        public String getRelationName() {
            return relationType.getRelationName();
        }

        public Human getWithWho() throws NullPointerException {
            return withWho;
        }

        static public enum RelationTypes {

            SEARCHING("Actively searching", false),
            IN_LOVE("In love", true),
            COMPLEX("Everything is complex", true),
            MARRIED("Marriede", true),
            SINGLE("Single", false);

            private final String relationName;
            private final boolean isAllowed;

            RelationTypes(final String relationName, boolean isAllowed) {
                this.relationName = relationName;
                this.isAllowed = isAllowed;
            }

            public boolean isAllowed() {
                return isAllowed;
            }

            public String getRelationName() {
                return relationName;
            }

        }

    }
}
