/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.unittesting;

import com.mycompany.unittesting.YearOutOfBoundsException;

/**
 *
 * @author Athinodoros
 */
public class dateCalculator {

    public static int getNumDaysinMonth(int month, int year) throws MonthOutOfBoundsException, YearOutOfBoundsException {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month > 12 || month < 1) {
            throw new MonthOutOfBoundsException();
        } else {
            if (year < 0 || year > Integer.MAX_VALUE - 1) {
                throw new YearOutOfBoundsException();
            } else if (year % 4 == 0) {
                if (year % 100 == 0 && year % 400 != 0) {//not a leap year
                    return months[month - 1];
                } else { // leap year
                    if (month - 1 == 1) {//february on leap year
                        return months[month - 1] + 1;
                    }
                    return months[month - 1];
                }
            } else {
                return months[month - 1];
            }
        }
    }
}
