import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int qtde = quantidadeTemperatura();

    }


    public static int quantidadeTemperatura(){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int qtde = 0;

        while (loop) {

            System.out.println("Insira a quantidade de temperatura para converter:");
            String s = sc.nextLine();;
            try {
                qtde = Integer.parseInt(s);
                loop = false;
            } catch (NumberFormatException e) {
                System.out.println("O valor deve ser um numero inteiro");
            }
        }
        return qtde;
    }



}












/*


    final double FATOR_UM = 9.0/5.0;
    final double FATOR_DOIS = 32;

    double celsiusUm = 33.5;
    double celsiusDois = 19.2;

    double fahrenheit = conversao(celsiusUm, FATOR_UM, FATOR_DOIS);
    System.out.printf("A temperatura %.2fºC é igual à %.2fºF\n", celsiusUm, fahrenheit);
    fahrenheit = conversao(celsiusDois, FATOR_UM, FATOR_DOIS);
    System.out.printf("A temperatura %.2fºC é igual à %.2fºF", celsiusDois, fahrenheit);

}

    public static double conversao(double celsius, double fatorUm, double fatorDois){

        double fahrenheit = (celsius * fatorUm) + fatorDois;
        return fahrenheit;
    }
}
*/