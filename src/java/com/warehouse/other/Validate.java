/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.other;

/**
 *
 * @author pawel_000
 */
public class Validate {
    public static boolean checkNumbersInString(String phrase) {
        boolean result = true;
        
        if (phrase.length() >= 1) {
            for (int i = 33; i < 65; i++)
                if (phrase.contains(String.valueOf(i))) {
                    result = false;
                    break;/*contains*/
                }
            
            for (int i = 91; i < 97; i++)
                if (phrase.contains(String.valueOf(i))) {
                    result = false;
                    break;/*contains*/
                }

            for (int i = 123; i < 256; i++)
                if (phrase.contains(String.valueOf(i))) {
                    result = false;
                    break;/*contains*/
                }
        }
        else
            result = false;

        return result;
    }
}
