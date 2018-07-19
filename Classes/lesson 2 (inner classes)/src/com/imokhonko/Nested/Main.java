package com.imokhonko.Nested;

public class Main {

    public static void main(String[] args) {

        Human vanya = new Human ("Ivan", 19);
        Human viola = new Human ("Viola", 19);

        vanya.setRelations(Human.Relations.RelationTypes.COMPLEX, viola);

        System.out.println (vanya.getName () + " (" + vanya.getAge () + " лет)");
        System.out.println (vanya.getRelations().getRelationName());
        try {
            System.out.println ("with " + vanya.getRelations().getWithWho().getName());
        } catch (Exception e) {}
    }
}
