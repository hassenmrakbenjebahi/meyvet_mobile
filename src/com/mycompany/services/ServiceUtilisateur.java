/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.utils.Statics;
import com.codename1.io.JSONParser;
import com.mycompany.myapp.BaseMagasin;
import com.mycompany.myapp.BaseProprietaire;
import com.mycompany.myapp.BaseVeterinaire;
import com.mycompany.myapp.NewsfeedForm;
import com.mycompany.myapp.SessionManager;
import com.mycompany.myapp.SignInForm;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Map;


/**
 *
 * @author user
 */
public class ServiceUtilisateur {
     //singleton 
    public static ServiceUtilisateur instance = null ;
    
    public static boolean resultOk = true;
    String json;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceUtilisateur getInstance() {
        if(instance == null )
            instance = new ServiceUtilisateur();
        return instance ;
    }
    
    
    
    public ServiceUtilisateur() {
        req = new ConnectionRequest();
        
    }
    
      //Signup veterinaire
    public void registre_veterinaire(TextField email,TextField nom,TextField prenom,TextField password,TextField pays,TextField gouvernorat,TextField ville ,TextField rue ,TextField telephone,Resources res ) {
        
     
        
        String url = Statics.BASE_URL+"/user/service/registration_veterinaire/?email="+email.getText().toString()+"&nom="+nom.getText().toString()+"&prenom="+prenom.getText().toString()+
                "&password="+password.getText().toString()+"&pays="+pays.getText().toString()+"&gouvernorat="+gouvernorat.getText().toString()+"&ville="+ville.getText().toString()+"&rue="+rue.getText().toString()+"&telephone="+telephone.getText().toString();
        
        req.setUrl(url);
       
        //Control saisi
        if(email.getText().equals("") || password.getText().equals("") || nom.getText().equals("")|| prenom.getText().equals("")|| pays.getText().equals("")|| gouvernorat.getText().equals("")|| ville.getText().equals("")|| rue.getText().equals("")||telephone.getText().equals("")) {
            
            Dialog.show("Erreur","Veuillez remplir les champs","OK",null);
            
        }
        else{
        //hethi wa9t tsir execution ta3 url 
        req.addResponseListener((e)-> {
         
            //njib data ly7atithom fi form 
            byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField 
            String responseData = new String(data);//ba3dika na5o content 
            
            System.out.println("data ===>"+responseData);
        }
        );
        
        
        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
         new SignInForm(res).show();
            Dialog.show("felicitation","vétérinaire est ajouté avec succès","OK",null);
        }
    }
    
    
         //Signup veterinaire
    public void registre_proprietaire(TextField email,TextField nom,TextField prenom,TextField password,TextField pays,TextField gouvernorat,TextField ville ,TextField rue ,TextField telephone,Resources res ) {
        
     
        
        String url = Statics.BASE_URL+"/user/service/registration_Proprietaire/?email="+email.getText().toString()+"&nom="+nom.getText().toString()+"&prenom="+prenom.getText().toString()+
                "&password="+password.getText().toString()+"&pays="+pays.getText().toString()+"&gouvernorat="+gouvernorat.getText().toString()+"&ville="+ville.getText().toString()+"&rue="+rue.getText().toString()+"&telephone="+telephone.getText().toString();
        
        req.setUrl(url);
       
        //Control saisi
        if(email.getText().equals("") || password.getText().equals("") || nom.getText().equals("")|| prenom.getText().equals("")|| pays.getText().equals("")|| gouvernorat.getText().equals("")|| ville.getText().equals("")|| rue.getText().equals("")||telephone.getText().equals("")) {
            
            Dialog.show("Erreur","Veuillez remplir les champs","OK",null);
            
        }
        else{
        //hethi wa9t tsir execution ta3 url 
        req.addResponseListener((e)-> {
         
            //njib data ly7atithom fi form 
            byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField 
            String responseData = new String(data);//ba3dika na5o content 
            
            System.out.println("data ===>"+responseData);
        }
        );
        
        
        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
        new SignInForm(res).show();
            Dialog.show("felicitation","Propriétaire est ajouté avec succès","OK",null);
        }
            
        
    }
    
    
    
           //Signup veterinaire
    public void registre_magasin(TextField email,TextField nom,TextField password,TextField pays,TextField gouvernorat,TextField ville ,TextField rue ,TextField telephone,Resources res ) {
        
     
        
        String url = Statics.BASE_URL+"/user/service/registration_magasin/?email="+email.getText().toString()+"&nom="+nom.getText().toString()+
                "&password="+password.getText().toString()+"&pays="+pays.getText().toString()+"&gouvernorat="+gouvernorat.getText().toString()+"&ville="+ville.getText().toString()+"&rue="+rue.getText().toString()+"&telephone="+telephone.getText().toString();
        
        req.setUrl(url);
       
        //Control saisi
        if(email.getText().equals("") || password.getText().equals("") || nom.getText().equals("")|| pays.getText().equals("")|| gouvernorat.getText().equals("")|| ville.getText().equals("")|| rue.getText().equals("")|| telephone.getText().equals("")) {
            
            Dialog.show("Erreur","Veuillez remplir les champs","OK",null);
            
        }
        else{
        //hethi wa9t tsir execution ta3 url 
        req.addResponseListener((e)-> {
         
            //njib data ly7atithom fi form 
            byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField 
            String responseData = new String(data);//ba3dika na5o content 
            
            System.out.println("data ===>"+responseData);
        }
        );
        
        
        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
        new SignInForm(res).show();
            Dialog.show("felicitation","Magasin est ajouté avec succès","OK",null);
        }
    }
        
        
        
    
    
    
    
    
    public void signin(String email,String password, Resources rs ) { 

        try {
        req.setPost(false);
        req.setUrl("http://127.0.0.1:8000/service/login/");
        req.addArgument("email",email);
        req.addArgument("password", password);

        }
        catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("A");
        }
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            

            try {
                Map<String,Object> Response = j.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
                
                String ErrorMessage = Response.get("Error").toString();
                if (!ErrorMessage.equals("")) {
                    Dialog.show("erreur","email n\'existe pas","OK",null);
                }
                else {
                    float id = Float.parseFloat(Response.get("id").toString());
                    SessionManager.setId((int)id);
                    //Session 
                     SessionManager.setMotdepasse(password);
                     SessionManager.setNom(Response.get("nom").toString());
                     SessionManager.setPrenom(Response.get("prenom").toString());
                     SessionManager.setEmail(Response.get("email").toString());
                     SessionManager.setVille(Response.get("ville").toString());
                     SessionManager.setPays(Response.get("pays").toString());
                     SessionManager.setGouvernorat(Response.get("gouvernorat").toString());
                     SessionManager.setAutoriser("oui");

                    if(Response.get("role").toString().equals("veterinaire") && SessionManager.getAutoriser()=="oui" ){
                     new BaseVeterinaire(rs).show();

                    }
                    if(Response.get("role").toString().equals("proprietaire")&& SessionManager.getAutoriser()=="oui"){

                    new BaseProprietaire(rs).show();
                    }
                    if(Response.get("role").toString().equals("magasin")&& SessionManager.getAutoriser()=="oui"){

                    new BaseMagasin(rs).show();
                    }

                   
                }   
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }     
            
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
        
    }

