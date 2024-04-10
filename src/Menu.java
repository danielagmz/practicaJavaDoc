/**
 * crear una funcio nova sense param d'entrada però amb retorn
 * marcar les tasques pendents amb l'etiqueta que toqui
 * a la capçalera dels fitxers java: posar versió, autor i data
 * a cadascuna de les funcions: param, return i descripcio
 */

import java.util.Scanner;
import java.lang.Math;

/**
 * clase menu que se llama para ejecutar el programa
 * @author daniela
 * @data 05/04/2024
 * @version 1.0
 */
public class Menu {
    /**
     * variable de lectura por teclado
     */
    private Scanner in = new Scanner(System.in);
    /**
     * variable de seleccion del menu
     */
    private int opcio;
    /**
     * vector que contiene 10 numeros
     */
    private int [] vector ;
    /**
     * matriz de 10x10
     */
    private int [][] matriu = new int[10][10];

    /**
     * funcion que gestiona el menu de opciones del programa
     */
    public void menuPrincipal() {
        do {
            System.out.println("1. Crear un vector");
            System.out.println("2. Parells i Senars");
            System.out.println("3. Trobar un número parell");
            System.out.println("4. Mostrar contingut");
            System.out.println("5. Generar matriu aleatoria");
            System.out.println("0. Acabar");
            System.out.print("Entra una opció(0-4): ");
            opcio = in.nextInt();
            in.nextLine();

            switch (opcio) {
                case 1:
                    //crear un vector
                    System.out.print("Entra la llargada del vector: ");
                    int n = 0;
                    try {
                        n = in.nextInt();
                        if (n!=0) {
                            vector = new int[n];
                        }else {
                            throw new IllegalArgumentException("L'array ha de tenir una llargada");
                        }

                    } catch (NegativeArraySizeException e) {
                        System.out.println("No pots tenir un array amb llargada negativa");
                    } catch (IllegalArgumentException e1){
                        System.out.println(e1.getMessage());
                    }
                    crearVector(vector,n);
                    break;
                case 2:
                    //comprovar si hi ha més parells o senars dins d'una matriu
                    parellsoSenars(matriu);

                    break;
                case 3:
                    //cercar números parells dins d'un vector
                    try {
                        if (hihaParells(vector)) {
                            System.out.println("s'ha trobat números parells al vector");
                            }
                        else System.out.println("No s'ha trobat números parells!!!");
                    } catch (NullPointerException e) {
                        System.out.println("Primer has de crear un vector per cercar numeros a dins ");
                    }

                    break;
                case 4:
                    //mostrar el contingut del vector
                    mostrarContingut(vector);
                    break;
                case 5:
                    //mostrar el contingut del vector
                    omplirMatriu(matriu);
                    break;
                case 0:
                    System.out.println("Gràcies. Fins la propera!");
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 4");

            }
            System.out.println();
        }while(opcio != 0);
    }

    /**
     * omple una matriu que se le pase amb numeros aleatoris y els mostra
     * @param matriu la matriu a omplir
     */
    private void omplirMatriu(int[][] matriu) {
        //ToDo incloure aquesta funcio a la de parellsoSenars() perque es mostri la matriu avanç de contar
        for (int i = 0; i < matriu.length ; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                matriu[i][j]=(int)Math.floor(Math.random()*10);
                System.out.print(matriu[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * metodo que crea un vector de 10 numeros aleatorios en un rango de 0 a un numero entrado por taclado
     * @param vector el vector a rellenar
     * @param n indica el largo del vector
     */

    public static void crearVector(int []vector,int n){

        for (int i = 0; i < n; i++) { //omplim vector
            vector[i] = (int)Math.floor(Math.random()*10);
            System.out.print(vector[i]+" ");
        }
    }

    /**
     * busca numeros pares o impares en la matriz que se le pase, luego imprime de cual hay mas o "empate" si hay igual cantidad
     * @param matriu matriz en la que buscar
     */
    public static void parellsoSenars(int [][]matriu){
        //ToDo: aquesta funció ha de retornar el total de números parells o senars segons qui guanyi
        int parell=0,senar=0;

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu.length; j++){
                matriu[i][j] = (int)Math.floor(Math.random()*10);
                if (matriu[i][j]% 2 == 0) {
                    parell = parell + 1;
                } else {
                    senar = senar + 1;
                }
            }
        }
        if (parell > senar){
            System.out.println("hi ha més parells que senars");
        }
        else if (senar > parell){
            System.out.println("hi ha més senars que parells");
        }
        else System.out.println("empat!");
    }

    /**
     * busca numeros pares en el vector proporcionado
     * @param vector vector en el que buscar
     * @return retorna true luego de imprimir si hay o no numeros pares
     */
    public static boolean hihaParells(int [] vector){
        int i=0;
        while ((vector[i]%2 != 0) && (i <= vector.length)){  //v.length ens diu la longitud del vector
            i=i+1;
        }

        if (i != vector.length){
            System.out.println("hi ha almenys un número parell");
        }
        else System.out.println("no s'ha trobat cap número parell");

        return true;
    }

    /**
     * muestra el contenido del vector que se le pase
     * @param vector indica el vector a tratar
     */
    public static void mostrarContingut(int [] vector){
        //PENDENT: aquesta funció està condicionada a l'execució d'alguna  de les funcions anteriors
        try {
            int i=0;
            for (int e : vector) {
                System.out.print(e+" ");
            }


        } catch (NullPointerException e) {
            System.out.println("Primer has de tenir un vector que mostrar!!");
        }
    }

}
