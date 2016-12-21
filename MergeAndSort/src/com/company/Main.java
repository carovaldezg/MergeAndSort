//Developed by Carolina VG on Dec 21st, 2016.


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

                //caso en el que el elemento "i" del arreglo A es menor que el elemento j del arreglo B
                if (src_a[i] < src_b[j]) {
                    result[k] = src_a[i];
                    i++;
                    k++;
                }
                //caso en el que el elemento "j" del arreglo B es menor que el elemento i del arreglo A
                else
                    if (src_b[j] < src_a[i]) {
                        result[k] = src_b[j];
                        j++;
                        k++;
                     }
                    //Caso en el que los elementos de ambos arreglos son iguales.
                     else

                          if (k > 0)
                              //Si en el resultado ya hay un valor repetido, no se debe volver a agregar
                              if (result[k-1] != src_a[i]) {
                                result[k] = src_a[i];
                                i++;
                                j++;
                                k++;
                                }
                                else
                                    i++;
                          //Este caso se utiliza cuando los arreglos tienen un solo elemento y este tiene el mismo valor numerico.
                          //Entonces, no tengo ningun elemento en el arreglo resultado todavia y solo almaceno uno de los valores.
                           else
                            {
                                result[k] = src_a[i];
                                k++;
                                i++;
                            }



            }

        //Si el arreglo A es mas largo que el B agrego todos sus valores a resultado si estos no estan repetidos
        while (i < max_a) {

            if (k > 0) {
                if (src_a[i] != result[k-1]) {
                    result[k] = src_a[i];
                    k++;
                }

            }
            //Caso en el que hay un solo elemento y el arreglo resultado no posee elementos todavia.
            else
            {
                result[k] = src_a[i];
                k++;
            }
            i++;

        }

        //Lo mismo sucede si el arreglo B es mas largo que el A
        while (j < max_b) {
           if (k > 0) {
               if (src_b[j] != result[k - 1]) {
                   result[k] = src_b[j];

                   k++;
               }

           }
           else
               result[k] = src_b[j];
            j++;
        }

        printArray (result);
    }




    public static void main(String[] args) {

        int [] src_a = {8,10,10};
        int [] src_b = {1,2,9};
        int [] result = new int [src_a.length + src_b.length];

        //Ya que no se admiten elementos repetidos, es necesario iniciar las posiciones del arreglo resultado con algún valor característico
        //debido a que la longitud continúa siendo la sumas de las longitudes de los arreglos A y B. Esto permite una mejor comprensión de los
        //datos del arreglo que se muestran por consola al finalizar la ejecución del método merge.
        for (int index = 0; index < result.length; index++)
            result[index] = -1000;
        merge(src_a, src_b, result);

    }
}
