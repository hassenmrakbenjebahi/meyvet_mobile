/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;


/**
 *
 * @author user
 */
public class Utilisateur {
    private int id;
    private String email;
    private String nom;
    private String prenom;
    private String motdepasse;
    private String pays;
    private String gouvernorat;
    private String ville;
    private String rue;
    private String telephone;

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    private String permistravail;
    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

   

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setPermistravail(String permistravail) {
        this.permistravail = permistravail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getPays() {
        return pays;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public String getPermistravail() {
        return permistravail;
    }






    public Utilisateur(String email,String nom, String prenom, String motdepasse,String pays,String gouvernorat, String ville, String rue) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.pays = pays;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.rue = rue;
    }
    
    
     @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", motdepasse=" + motdepasse + ", pays=" + pays + ", gouvernorat=" + gouvernorat + ", ville=" + ville + ", rue=" + rue + ", permistravail=" + permistravail +", telephone=" + telephone + '}';
    }
    
}
