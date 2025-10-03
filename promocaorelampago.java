import java.math.BigDecimal;
import java.util.Scanner;

public class promocaorelampago {


    // onde recebe o valor da compra
    public static void main(String[] args) {
        System.out.println("Informe o valor da compra");
        Scanner scanner = new Scanner(System.in);
        String valorCompra = scanner.nextLine();
        System.out.println(calcularDesconto(valorCompra));
        scanner.close();
    }

    // onde vai ser calculado e dependendo da condição a mensagem criada
    public static String calcularDesconto(String valorCompra) {
        BigDecimal valor = new BigDecimal(valorCompra);
        BigDecimal valorComDesconto;
        BigDecimal descontoPercentual;
        try {
            BigDecimal desconto10Porcento = new BigDecimal("0.10");
            BigDecimal desconto20Porcento = new BigDecimal("0.20");
            BigDecimal limiteInferior = new BigDecimal("50");
            BigDecimal limiteSuperior = new BigDecimal("100");

            valorComDesconto = valor;

            String mensagem;
            if (valor.compareTo(limiteInferior) < 0) {
                mensagem = String.format("O valor da compra é de R$ %.2f. Não há desconto.", valorComDesconto);
            }else if (valor.compareTo(limiteSuperior) <= 0) {
                BigDecimal valorDesconto = valor.multiply(desconto10Porcento);
                descontoPercentual = valor.subtract(valorDesconto);
                mensagem = String.format("O valor é %.2f. recebeu desconto de 10%%. Novo valor %.2f.", valor, descontoPercentual);
            }else {
                BigDecimal valorDesconto = valor.multiply(desconto20Porcento);
                descontoPercentual = valor.subtract(valorDesconto);
                mensagem = String.format("O valor é %.2f. recebeu desconto de 20%%. Novo valor %.2f.", valor, descontoPercentual);

            }
            // onde a mensagem é printada
            return mensagem;

        }catch (NumberFormatException e) {
            return "Entrada inválida. Digite um número válido.";

        }
    }

}
