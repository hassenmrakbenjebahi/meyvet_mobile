/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.myapp;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUtilisateur;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends BaseForm {

    public SignUpForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
                
        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField nom = new TextField("", "Nom", 20, TextField.ANY);
        TextField prenom = new TextField("", "Prenom", 20, TextField.ANY);
        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
        TextField pays = new TextField("", "Pays", 20, TextField.ANY);
        TextField gouvernorat = new TextField("", "Gouvernorat", 20, TextField.ANY);
        TextField ville = new TextField("", "Ville", 20, TextField.ANY);
        TextField rue = new TextField("", "Rue", 20, TextField.ANY);
        TextField telephone = new TextField("", "telephone", 20, TextField.ANY);

        username.setSingleLineTextArea(false);
        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        nom.setSingleLineTextArea(false);
        prenom.setSingleLineTextArea(false);
        pays.setSingleLineTextArea(false);
        gouvernorat.setSingleLineTextArea(false);
        ville.setSingleLineTextArea(false);
        rue.setSingleLineTextArea(false);
        telephone.setSingleLineTextArea(false);

        Button next = new Button("enregistrer");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Avez-vous un compte?");
        
        Container content = BoxLayout.encloseY(
                new Label("Inscription Vétérinaire", "LogoLabel"),

                new FloatingHint(email),
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                
                new FloatingHint(pays),
                createLineSeparator(),
                new FloatingHint(gouvernorat),
                createLineSeparator(),
                new FloatingHint(ville),
                createLineSeparator(),
                new FloatingHint(rue),
                createLineSeparator(),
                new FloatingHint(telephone),
                createLineSeparator()
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
          next.requestFocus();
        next.addActionListener((e) -> {
            
            ServiceUtilisateur.getInstance().registre_veterinaire(email, nom, prenom, password, pays,gouvernorat,ville,rue,telephone, res);
            //Dialog.show("felicitation","vétérinaire est ajouté avec succès","OK",null);
           

        });
    }
    
}
