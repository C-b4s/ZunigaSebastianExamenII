package ZSInfrastructureComponent.ZSTools;

import java.util.Scanner;

public class ZSCMDInput {
    static Scanner sc = new Scanner(System.in);
    private ZSCMDInput(){}

    
    /**
     * Captura un numero entero y que sea mayor a cero
     * @param zsEtiqueta
     * @return numero entero positivo
     */
    public static int getNumeroPositivo(String zsEtiqueta, String zsErrorMsg){
        int n =-1;
        String zsStr;
        do{
            System.out.print(zsEtiqueta);
            zsStr =  sc.next();
            try {
                n = Integer.parseInt(zsStr);
            } catch (Exception _) {
                System.out.println(zsErrorMsg);
            }
        }while(n<0);
        return n;
    }
    
    public static String getCaracteres(String zsEtiqueta)
    {
        String zsStr="";
        do {
            System.out.print(zsEtiqueta);
            zsStr =  sc.next().trim();
            if (zsStr.trim().equals(""))
                System.out.println(" :( Valor no valido... !");
        } while (zsStr.isEmpty());
        return zsStr;
    }

    public static void pressKey()
    {
        System.out.print("\n\nPress any key..");
        try{
            System.in.read();
        }catch(Exception _){
            System.out.println("");
        }
    }
}

