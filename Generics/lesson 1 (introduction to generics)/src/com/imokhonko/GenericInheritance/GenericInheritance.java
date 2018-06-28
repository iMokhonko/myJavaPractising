package com.imokhonko.GenericInheritance;

import java.util.ArrayList;
import java.util.List;

public class GenericInheritance {


    public static void main(String[] args) {

        GenericInheritance genericInheritance = new GenericInheritance();

        List<Child> parents = new ArrayList<> ();
        List<Parent> children = new ArrayList<> ();

        Parent parentVanya = new Parent ("Ivan");
        Parent parentViola = new Parent ("Viola");

        Child child = new Child ("Sanya");

        parents.add(child);

        children.add (parentVanya);
        children.add (parentViola);

        System.out.println("parents:");
        genericInheritance.parents(children);

        System.out.println("childrens:");
        genericInheritance.childrens(parents);



    }

    // Добавляем метод который может содержать list которые имеет тип Child и выше по иерархии классов Parent, Object
    void childrens(List<? super Child> list) {
        System.out.println (list);
    }

    // Добавляем метод который может содержать list которые имеет тип Parent и ниже по иерархии классов Child
    void parents(List<? extends Parent> list) {
        System.out.println (list);
    }


}
