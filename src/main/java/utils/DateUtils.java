/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DateUtils {
    private static final SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat fechaFormatoPersonalizado = new SimpleDateFormat("dd-MM-yyyy"); 

    public static String formatearFecha(Date fecha) {
        if (fecha != null) {
            return fechaFormato.format(fecha);
        } else {
            return "";
        }
    }
    
    public static String formatearFechaPerso(Date fecha) {
        if (fecha != null) {
            return fechaFormatoPersonalizado.format(fecha);
        } else {
            return "";
        }
    }
    
    public static Date parseFecha(String fechaStr) {
        try {
            return fechaFormato.parse(fechaStr);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    

    
}
