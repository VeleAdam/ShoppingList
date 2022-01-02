package com.example.zkouska;

import java.util.ArrayList;

public class SeznamSeznamu {

    private ArrayList<NakupniSeznam> listseznamu ;

    public SeznamSeznamu()
    {
        listseznamu = new ArrayList<NakupniSeznam>();
    }

    public void pridejSeznam(NakupniSeznam novy)
    {
        listseznamu.add(novy);

    }

    public void odeberPolozku(NakupniSeznam nazevseznamu)
    {
        listseznamu.remove(nazevseznamu);

    }
}
