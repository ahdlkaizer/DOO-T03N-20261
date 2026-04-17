import java.util.ArrayList;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double valorTotal;
    double desconto;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    public void mostrarVenda() {
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço unitário: R$ " + precoUnitario);
        System.out.println("Desconto: R$ " + desconto);
        System.out.println("Valor final: R$ " + valorTotal);
        System.out.println("----------------------------");
    }
}

public class CalculadoraMyPlant {

    static ArrayList<Venda> vendas = new ArrayList<>();

    public static double calcularTotal(int quantidade, double preco) {
        double total = quantidade * preco;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
            System.out.println("Desconto de 5% aplicado!");
        }

        // Registrar venda
        vendas.add(new Venda(quantidade, preco, total, desconto));

        return total;
    }

    public static void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda v : vendas) {
                v.mostrarVenda();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Sistema My Plant ===");
            System.out.println("1 - Nova venda");
            System.out.println("2 - Listar vendas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Quantidade de plantas: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço unitário: ");
                    double preco = scanner.nextDouble();

                    double total = calcularTotal(quantidade, preco);

                    System.out.println("Valor final a pagar: R$ " + total);
                    break;

                case 2:
                    listarVendas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}