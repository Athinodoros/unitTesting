/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDeductable;

import com.mycompany.unittesting.Deductable;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Athinodoros
 */
@RunWith(Parameterized.class)
public class JUnitTestDeductable {
    
    int expected;
    boolean deductableMet ;
    boolean doctorVisit ;
    boolean hospitalVisit ;
    public JUnitTestDeductable(int exp,boolean ded,boolean doc,boolean hos) {
        expected = exp;
        deductableMet=ded;
        doctorVisit = doc;
        hospitalVisit = hos;
    }
    
    
     @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {80,true,false,true},//negative month
            {50,true,true,false},//negative month
            {0,false,true,false},//negative month
            {0,false,false,true},//negative month          
        });
    }
    
    @Before
    public void setUp() {
    }

   @Test
   public void testDeductable(){
       assertEquals(expected, Deductable.getDeductable(deductableMet,doctorVisit,hospitalVisit));
   }
}
