/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unittesting;

/**
 *
 * @author Athinodoros
 */
public class Deductable {

    public static int getDeductable(boolean deductableMet, boolean doctorVisit, boolean hospitalVisit) {
        if(deductableMet){
            if(hospitalVisit)
            {
                return 80;
            }else if(doctorVisit){
                return 50;
            }else
                return 0;
        }else
        return 0;
    }
    
}
