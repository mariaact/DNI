package com.proyecto;

/**
 * Hello world!
 *
 */
public class App {

    static boolean dniCorrecto = false;
    static int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] tablaValidacion = {'T', 'R', 'W', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    static boolean verificarDNI;

    public static void main(String[] args) throws ValidarDNIErrores {
        System.out.println(comprobarDNI9Caracteres8PrimerosNumerosUltimoLetra("154858528"));

        // System.out.println(comprobarDNI9Caracteres8PrimerosNumerosUltimoLetra("00000000T"));
    }

    public static boolean comprobarDNI(String dni) throws ValidarDNIErrores{

        if (comprobarDNI9Caracteres(dni) && comprobarDNI9Caracteres8PrimerosNumerosUltimoLetra(dni) && comprobarDNI9Caracteres(dni) && comprobacionTabla(dni)) {
            verificarDNI = true;
        } else {
            verificarDNI = false;
        }

        return verificarDNI;
    }

    public static boolean comprobarDNI9Caracteres(String dni) {
        try {
            if (dni.length() != 9) {
                throw new ValidarDNIErrores("Ha introducido mal el DNI. El número de caracteres tiene que ser 9");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (dni.length() == 9) {
            dniCorrecto = true;
        } else {
            dniCorrecto = false;
        }

        return dniCorrecto;
    }

    public static boolean comprobarDNI9Caracteres8PrimerosNumerosUltimoLetra(String dni) {
        int cont = 0;
        int letraUltimaPosicion = 0;

        if (dni.length() == 9) {
            for (int i = 0; i < dni.length() - 1; i++) {
                for (int j = 0; j < numeros.length; j++) {
                    if (numeros[j] == Character.getNumericValue(dni.charAt(i))) {
                        cont++;
                    }
                }
            }

            //comprobar que el ultimo valor sea una letra y no puede ser ni la U, I, O, Ñ 
            for (int i = 0; i < letras.length; i++) {
                if (Character.toUpperCase(dni.charAt(8)) == Character.toUpperCase(letras[i])
                        && Character.toLowerCase(letras[i]) != 'o' && Character.toLowerCase(letras[i]) != 'u' && Character.toLowerCase(letras[i]) != 'i') {
                    letraUltimaPosicion++;
                }
            }
        }

        try {
            if (cont == 8 && letraUltimaPosicion == 1) {
                dniCorrecto = true;
            } else {
                dniCorrecto = false;
                throw new ValidarDNIErrores("Ha introducido mal el DNI. El ultimo caracter tiene que ser una letra");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* if (cont == 8 && letraUltimaPosicion == 1) {
            dniCorrecto = true;
        } else {
            dniCorrecto = false;
        }*/
        return dniCorrecto;
    }

    public static boolean comprobacionTabla(String dni) {
        int suma = 0;
        boolean letraCorrecta = false;
        int resto = 0;

        for (int i = 0; i < dni.length() - 1; i++) {
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] == Character.getNumericValue(dni.charAt(i))) {
                    suma += Character.getNumericValue(dni.charAt(i));
                }
            }
        }
        resto = suma % 23;

        /*
        if(Character.toLowerCase(tablaValidacion[resto]) == Character.toLowerCase(dni.charAt(8))){
            letraCorrecta = true;
        }else{
			letraCorrecta = false;
			throw new ValidarDNIErrores("Ha introducido mal el DNI. La letra es erronea tabla");
        }
         */
        try {
            if (Character.toLowerCase(tablaValidacion[resto]) == Character.toLowerCase(dni.charAt(8))) {
                letraCorrecta = true;
            } else {
                letraCorrecta = false;
                throw new ValidarDNIErrores("Ha introducido mal el DNI. La letra es erronea tabla");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return letraCorrecta;
    }

    public static boolean compobacionNIE(String nie) throws ValidarDNIErrores  {


		boolean result = false;
		try {
			if (nie.charAt(0) == '0' || nie.charAt(0) == '1' || nie.charAt(0) == '2') {
				result = comprobarDNI(nie);
			}
		} catch (Exception e) {
			throw new ValidarDNIErrores("el NIE no empieza por la letra que le corresponde");

		}
        

        return result;
    }
}
