/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.io.Preferences;

/**
 *
 * @author user
 */
public class SessionManager {
    public static Preferences pref ; 
    private static int id;
    private static String email;
    private static String nom;
    private static String prenom;
    private static String motdepasse;
    private static String pays;
    private static String gouvernorat;
    private static String ville;
    private static String rue;
    private static String autoriser;

    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }
      public static String getAutoriser() {
        return pref.get("autoriser",autoriser); 
    }
    public static void setAutoriser(String autoriser) {
        pref.set("autoriser",autoriser);
    }
      public static int getId() {
        return pref.get("id",id);
    }
    public static void setId(int id) {
        pref.set("id",id);
    }

    public static void setEmail(String email) {
        pref.set("email",email);  
    }

    public static void setNom(String nom) {
        pref.set("nom",nom);
    }

    public static void setPrenom(String prenom) {
        pref.set("prenom",prenom);
    }

    public static void setMotdepasse(String motdepasse) {
       pref.set("motdepasse",motdepasse);
    }

    public static void setPays(String pays) {
        pref.set("pays",pays);
    }

    public static void setGouvernorat(String gouvernorat) {
        pref.set("gouvernorat",gouvernorat);
    }

    public static void setVille(String ville) {
        pref.set("ville",ville);
    }

    public static void setRue(String rue) {
        pref.set("rue",rue);
    }

    public static String getEmail() {
        return pref.get("email",email); 
    }

    public static String getNom() {
        return pref.get("nom",nom); 
    }

    public static String getPrenom() {
        return pref.get("prenom",prenom); 
    }

    public static String getMotdepasse() {
        return pref.get("motdepasse",motdepasse); 
    }

    public static String getPays() {
        return pref.get("pays",pays); 
    }

    public static String getGouvernorat() {
        return pref.get("gouvernorat",gouvernorat); 
    }

    public static String getVille() {
        return pref.get("ville",ville); 
    }

    public static String getRue() {
        return pref.get("rue",rue); 
    }
    
    
    
}
