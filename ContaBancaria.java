import java.util.Scanner;

public class ContaBancaria {
    private String nomePessoa;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String nomePessoa, int numeroConta, double saldoInicial) {
        this.nomePessoa = nomePessoa;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        }
    }

    public double obterSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();

        System.out.println("Digite o saldo inicial:");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        char opcao;

        do {
            System.out.println("\nSelecione a operação:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Saldo Disponível");
            System.out.println("Q - Sair");

            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case '1':
                    System.out.println("Digite o valor para depositar:");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case '2':
                    System.out.println("Digite o valor para sacar:");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case '3':
                    System.out.println("Saldo disponível: R$ " + conta.obterSaldo());
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 'Q' && opcao != 'q');

        scanner.close();
    }
}
