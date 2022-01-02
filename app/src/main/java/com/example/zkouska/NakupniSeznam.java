package com.example.zkouska;

import java.util.ArrayList;

public class NakupniSeznam {

    public String nazevSeznamu;

    public ArrayList<Polozka> listpolozek ;

    public NakupniSeznam()
    {
        listpolozek = new ArrayList<Polozka>();
    }

    public void pridejPolozku(Polozka nova)
    {
        listpolozek.add(nova);
    }

    public void odeberPolozku(Polozka nazevpolozky)
    {
        listpolozek.remove(nazevpolozky);

    }

    //metody pridej a odeber, seznam seznamů, soubor k našeptávači
}
