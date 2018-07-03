package com.imokhonko;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Map<Faculty, Student> studentACS = new LinkedHashMap<> ();
        Map<Faculty, Student> studentGRTB = new HashMap<> ();
        Map<Faculty, Student> studentPX = new HashMap<> ();
        Map<Faculty, Student> students = new HashMap<> ();

        Faculty aks = new Faculty ("AKS");
        Faculty grtb = new Faculty ("GRTB");
        Faculty PX = new Faculty ("PX");

        Student ivan = new Student (1, "Ivan");
        Student lexa = new Student (2, "Lexa");
        Student sanya = new Student (3, "Sanya");

        studentACS.put (aks, ivan);
        studentPX.put (PX, lexa);
        studentGRTB.put (grtb, sanya);

        students.putAll (studentACS);
        students.putAll (studentGRTB);
        students.putAll (studentPX);

        System.out.println (studentACS);



    }
}
