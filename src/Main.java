import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int qtde = quantidadeTemperatura();

        double[] tempEntrada = new double[qtde];
        double[] tempConvertido = new double[qtde];

        String unidadeEntrada = escolhaUnidade();
        String unidadeSaida = escolhaUnidade();

        if(unidadeEntrada.equals(unidadeSaida)){
            System.out.println("Você colocou unidades de medidas iguais, não pode realizar a operação!");
            System.exit(0);
        }

        for (int i = 0; i < tempEntrada.length; i++) {

            System.out.println("Insira a temperatura: ");
            while(true)
            try {
                tempEntrada[i] = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("O valor deve ser um numero inteiro");
            }

        }

        if(unidadeEntrada.equals("Celsius") && unidadeSaida.equals("Kelvin")){
            for (int i = 0; i < tempEntrada.length; i++) {
                tempConvertido[i] = tempEntrada[i] + 273.15;
            }
        }
        if(unidadeEntrada.equals("Kelvin") && unidadeSaida.equals("Celsius")){
            for (int i = 0; i < tempEntrada.length; i++) {
                tempConvertido[i] = tempEntrada[i] - 273.15;
            }
        }
        if(unidadeEntrada.equals("Celsius") && unidadeSaida.equals("Fahrenheit")){

            for (int i = 0; i < tempEntrada.length; i++) {
                tempConvertido[i] = (tempEntrada[i] * 1.8) + 32.0;
            }

        }
        if(unidadeEntrada.equals("Fahrenheit") && unidadeSaida.equals("Celsius")){
            for (int i = 0; i < tempEntrada.length; i++) {
                tempConvertido[i] = (tempEntrada[i] - 32) * (5.0/9.0);
            }
        }
        if(unidadeEntrada.equals("Kelvin") && unidadeSaida.equals("Fahrenheit")){
            for (int i = 0; i < tempEntrada.length; i++) {
                tempConvertido[i] = ((tempEntrada[i] - 273.15) * 1.8)+32;
            }
        }
        if(unidadeEntrada.equals("Fahrenheit") && unidadeSaida.equals("Kelvin")){
            for (int i = 0; i < tempEntrada.length; i++) {
                tempConvertido[i] = ((tempEntrada[i] - 32) * (5.0/9.0))+273.15;
            }
        }



        imprimaTemperatura(tempEntrada,unidadeEntrada, "de Entrada" );
        imprimaTemperatura(tempConvertido,unidadeSaida, "Convertida");

        double soma=0;
        double media = 0;
        double somaConv = 0;
        double mediaConv = 0;
        for (int i = 0; i < tempEntrada.length; i++) {

            soma += tempEntrada[i];
        }
        media = soma/qtde;
        System.out.printf("A média de temperatura de entrada é %.2f em %s\n", media, unidadeEntrada);
        //System.out.println("A média de temperatura de entrada é "+ media + " em " + unidadeEntrada);

        for (int i = 0; i < tempConvertido.length; i++) {

            somaConv += tempConvertido[i];
        }
        mediaConv = somaConv/qtde;
        System.out.printf("A média de temperatura de convertida é %.2f em %s\n", mediaConv, unidadeSaida);
        //System.out.println("A média de temperatura de entrada é "+ mediaConv+ " em " + unidadeSaida);







    }

    public static void imprimaTemperatura(double[] temp, String unidade, String x){
        System.out.println("As temperaturas "+x+" em : "+ unidade);
        for (int i = 0; i < temp.length; i++) {
            if(unidade.equals("Celsius")){
                System.out.printf("%.2f ºC\n", temp[i]);
            }
            if(unidade.equals("Kelvin")){
                System.out.printf("%.2f ºK\n", temp[i]);
            }
            if(unidade.equals("Fahrenheit")){
                System.out.printf("%.2f ºF\n", temp[i]);
            }

        }
    }


    public static int quantidadeTemperatura(){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int qtde = 0;

        while (loop) {

            System.out.println("Insira a quantidade de temperatura para converter:");
            String s = sc.nextLine();
            try {
                qtde = Integer.parseInt(s);
                loop = false;
            } catch (NumberFormatException e) {
                System.out.println("O valor deve ser um numero inteiro");
            }
        }

        System.out.println("A quantidade escolhida é: "+ qtde);
        return qtde;
    }

    public static String escolhaUnidade() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("Escolha a unidade de temperatura: " +
                    "\n digite 1 para Celsius; " +
                    "\n digite 2 para Kelvin;" +
                    "\n digite 3 para Fahrenheit: \n");
            try {
                int temp = Integer.parseInt(sc.nextLine());
                if (temp < 4 && temp > 0) {
                    switch (temp) {
                        case 1:
                            return "Celsius";
                        case 2:
                            return "Kelvin";
                        case 3:
                            return "Fahrenheit";
                        default:
                            break;
                    }
                    break;
                }
                System.out.println("insira um número válido");
            } catch (NumberFormatException e) {
                System.out.println("O valor deve ser um numero inteiro");
            }
        }
        return null;
    }

}

