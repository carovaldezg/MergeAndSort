package com.company;

public class Main {


    //Este procedimiento muestra el arreglo resultado

    public static void printArray(int[] result)
    {
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }



    //El siguiente código resuelve el ejercicio propuesto.
    // Siendo que los arreglos pueden tener dimensiones diferentes, es necesario considerar que cuando se llegue al final de uno
    //los elementos restantes del otro arreglo deberán ser agregados al arreglo resultado.
    //Se han considerado los siguientes casos:
    //    *Arreglos de igual dimensión
    //    *Uno o ambos arreglos vacíos
    //    *Arreglos de distinta dimensión.
    //    *Valores negativos
    //    *Valores iguales en ambos arreglos
    //    *Valores extremadamente altos y bajos que se insertaran en los extremos del arreglo resultado
    //    *Valores intermedios que se insertaran entre otros valores en el arreglo resultado

    //El costo computacional del ejercicio solicitado es O(n) ya que es necesario recorrrer como mínimo una vez cada elemento de ambos
    //arreglos para obtener el resultado ordenado.

    public static void merge (int []src_a, int [] src_b, int [] result) {

            int i = 0;
            int j = 0;
            int k = 0;

            //Con el objetivo de evitar el costo computacional de consultar la longitud del arreglo dentro de la iteración, se utilizan dos
           //variables adicionales para recordar las lonitudes de src_a y src_b.
            int max_a = src_a.length;
            int max_b = src_b.length;

            while (i < max_a && j < max_b) {

                if (src_a[i] <= src_b[j]) {
                    result[k] = src_a[i];
                    i++;
                    k++;
                }
                else {
                        result[k] = src_b[j];
                        j++;
                        k++;
                     }
             }

        while (i < max_a) {
            result[k] = src_a[i];
            i++;
            k++;
        }

        while (j < max_b) {
            result[k] = src_b[j];
            j++;
            k++;
        }


    }


    public static void main(String[] args) {
        int [] src_a = {};
        int [] src_b = {};
        int [] result = new int [src_a.length + src_b.length];
        merge(src_a, src_b, result);
        printArray (result);
    }
}
