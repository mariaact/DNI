package com.proyecto;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void comprobarDNI9Digitos() throws ValidarDNIErrores {
        assertEquals(true, App.comprobarDNI9Caracteres("154845285"));
    }

    @Test
    public void comprobarDNImenos9Digitos() throws ValidarDNIErrores {
        assertEquals(false, App.comprobarDNI9Caracteres("1548525"));
    }

    @Test
    public void comprobarDNImenos9DigitosExc(){
        try {
          App.comprobarDNI("1548525");
     } catch (ValidarDNIErrores e) {
          assertEquals(e.getMessage(), "Ha introducido mal el DNI. El número de caracteres tiene que ser 9");
     }
    }

    @Test
    public void comprobarDNImas9Digitos(){
        assertEquals(false, App.comprobarDNI9Caracteres("1548585285"));
    }

    @Test
    public void comprobarDNImas9DigitosExc() throws ValidarDNIErrores {

     try {
          App.comprobarDNI("1548585285");
     } catch (ValidarDNIErrores e) {
          assertEquals(e.getMessage(), "Ha introducido mal el DNI. El número de caracteres tiene que ser 9");
     }
    }

    @Test
    public void comprobarDNI9Caracteres8PrimerosNumerosUltimoLetraEXITO() throws ValidarDNIErrores {
        assertEquals(true, App.comprobarDNI("15485852q"));
    }

    @Test
    public void comprobarDNI9Caracteres8PrimerosNumerosUltimoLetraFALLIDO() throws ValidarDNIErrores {

        assertEquals(false, App.comprobarDNI("154858528"));
    }

    @Test
    public void comprobarDNI9Caracteres8PrimerosNumerosUltimoLetraFALLIDOExcepcion(){
          try {
               App.comprobarDNI("785425698");
          } catch (ValidarDNIErrores e) {
               assertEquals(e.getMessage(), "Ha introducido mal el DNI. El número de caracteres tiene que ser 9");
          }
    }

    @Test
    public void letrasExcepto() throws ValidarDNIErrores {
        assertEquals(false, App.comprobarDNI("15485852o"));
    }

    @Test
    public void letrasExceptu() throws ValidarDNIErrores {
        assertEquals(false, App.comprobarDNI("15485852u"));
    }

    @Test
    public void letrasExcepti() throws ValidarDNIErrores {
        assertEquals(false, App.comprobarDNI("15485852i"));
    }

    @Test
    public void comprobacionTablaOK() throws ValidarDNIErrores {
        assertEquals(true, App.comprobarDNI("00000000T"));
    }

    @Test
    public void comprobacionTablaFallo() throws ValidarDNIErrores {
        assertEquals(false, App.comprobarDNI("00000000G"));
    }

    @Test
    public void comprobacionTablaFalloExc() {
        try {
          App.comprobarDNI("00000000G");
     } catch (ValidarDNIErrores e) {
          assertEquals(e.getMessage(), "Ha introducido mal el DNI. La letra es erronea tabla");
     }
    }

    @Test
    public void comprobacionNIEOK() throws ValidarDNIErrores {
        assertEquals(true, App.comprobarDNI("05845852S"));
    }


    @Test
    public void comprobacionNIEExc() {
        try {
          App.comprobarDNI("45845852S");
     } catch (ValidarDNIErrores e) {
          assertEquals(e.getMessage(), "el NIE no empieza por la letra que le corresponde");
     }
    }
}
