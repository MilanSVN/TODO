/****************************************************************************
 *
 * Copyright (c) 2016 Elektrotehnički fakultet
 * Patre 5, Banja Luka
 *
 * All Rights Reserved
 *
 * \file Stavka.java
 * \brief
 * This class is used only for holding values.
 *
 * Created on 10.04.2016.
 *
 * @Author Milan Bojic
 *
 **********************************************************************/

package net.etfbl.prs.stavka;

public class Stavka {
    public String opis;
    public Boolean gotova;
    /************************************************************************/
    /**
     * @brief Constructor for Stavka
     *
     * @param o - String for setigup opis atribute
     * @return Stavka
     *************************************************************************/
    public Stavka (String o)
    {
        opis = o;
        gotova = false;
    }
}