/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;

/**
 *
 * @author 19535
 */
public class Main {

    public static void main(String[] args) {
        Medico md1 = new Medico(12345, "Sergio", "Mattarella", "SRGMTL05E11REGD4G6G", "presidente");
        Medico md2 = new Medico(10104, "Sofric", "Kristian", "SFCKSN11Q11YDH4IHJQ", "alcolizzato");
        Paziente pz1 = new Paziente(22222, "Gasparrini", "Alberto", "GPRLRT01T05YYTG4HID", 38055);
        System.out.println(pz1);
        pz1.setMedicoById(10104);
        System.out.println(pz1.toStringTrump());
        md2.add_IdPaziente(22222);
        
    }
}
