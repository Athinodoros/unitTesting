/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDate;


import com.mycompany.unittesting.MonthOutOfBoundsException;
import com.mycompany.unittesting.YearOutOfBoundsException;
import com.mycompany.unittesting.dateCalculator;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Athinodoros
 */
@RunWith(Parameterized.class)
public class JUnitTestDayCalc {
    
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Athinodoros
 */


    dateCalculator ddd = new dateCalculator();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    int inMonth;
    int inYear;
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public JUnitTestDayCalc(int month, int year) {
        inMonth = month;
        inYear = year;
    }

    @Before
    public void setUp() {
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {0, 2017},//negative month
            {1, 0},//not leap 0th year :P
            {13, 2000},//greater month
            {2, 2001},//normal month and year
            {2, 2000},//leapyear
            {2, 1900},//not-leap year %100
            {5, -1},////year out of bounds min
            {12, Integer.MAX_VALUE},//year out of bounds max
            {12, Integer.MAX_VALUE - 1}//year just in bounds
        });
    }

    @Test
    public void testDayCalculator() throws MonthOutOfBoundsException, YearOutOfBoundsException {
        if (inMonth > 12 || inMonth < 1) {
            thrown.expect(MonthOutOfBoundsException.class);
            dateCalculator.getNumDaysinMonth(inMonth, inYear);
        }
        if (inYear < 0 || inYear > Integer.MAX_VALUE - 1) {
            thrown.expect(YearOutOfBoundsException.class);
            dateCalculator.getNumDaysinMonth(inMonth, inYear);
        }
        if (inMonth < 13 && inMonth > 0 && inYear >= 0 && inYear < Integer.MAX_VALUE) {
            if ((inYear % 4 == 0 && inYear % 100 == 0 && inYear % 400 == 0) || (inYear % 4 == 0 && inYear % 100 != 0 && inYear % 400 != 0)) {//leap
                if (inMonth == 2) {
                    assertEquals("Correct Leap Year", months[inMonth - 1] + 1, dateCalculator.getNumDaysinMonth(inMonth, inYear));
                } else {
                    assertEquals("Correct Leap Year", months[inMonth - 1], dateCalculator.getNumDaysinMonth(inMonth, inYear));
                }
            } else if (inYear % 4 == 0 && inYear % 100 == 0 && inYear % 400 != 0) {
                assertEquals("Correct Leap Year", months[inMonth - 1], dateCalculator.getNumDaysinMonth(inMonth, inYear));
            }
        }

    }

}
