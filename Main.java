import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorAgencia gerenciador = new GerenciadorAgencia();

        System.out.println("=== SISTEMA DE GERENCIAMENTO DE AGÊNCIA DE RELACIONAMENTO ===");

       
        if (!new File("candidatos.txt").exists()) {
            GeradorDados.gerarArquivo("candidatos.txt", 15);
        }
        gerenciador.carregarCandidatos("candidatos.txt");

        int opcao;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Inserir/atualizar o grau de interesse desejado");
            System.out.println("2. Consultar potenciais companheiros de um candidato");
            System.out.println("3. Imprimir Top K candidatos com mais companheiros");
            System.out.println("4. Imprimir candidatos sem companheiros");
            System.out.println("5. Imprimir candidatos com interesse em uma área");
            System.out.println("6. Imprimir candidatos residentes em um estado");
            System.out.println("0. Sair");

            opcao = lerInt(scanner, "Escolha uma opção: ", 0, 6);

            switch (opcao) {
                case 1:
                    int novoGrau = lerInt(scanner, "Digite o novo grau de interesse desejado (ex: 6): ", 0, Integer.MAX_VALUE);
                    gerenciador.setGrauInteresse(novoGrau);
                    break;
                case 2:
                    int idCand = lerInt(scanner,
                            "Digite o ID do candidato (0 a " + (gerenciador.getTotalCandidatos() - 1) + "): ",
                            0, gerenciador.getTotalCandidatos() - 1);
                    gerenciador.tarefa2(idCand);
                    break;
                case 3:
                    int k = lerInt(scanner, "Digite o valor de K: ", 1, Integer.MAX_VALUE);
                    gerenciador.tarefa3(k);
                    break;
                case 4:
                    gerenciador.tarefa4();
                    break;
                case 5:
                    System.out.println("Áreas: 1: ESPORTES, 2: ARTES, 3: MÚSICA, 4: CINEMA, 5: TECNOLOGIA, 6: ANIMAIS, 7: GASTRONOMIA, 8: CIÊNCIAS");
                    int area = lerInt(scanner, "Digite o código da área de interesse (1 a 8): ", 1, 8);
                    gerenciador.tarefa5(area);
                    break;
                case 6:
                    System.out.print("Digite a sigla do estado (ex: SP, MG): ");
                    String estado = scanner.nextLine().trim();
                    gerenciador.tarefa6(estado);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

  
    private static int lerInt(Scanner sc, String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < min || valor > max) {
                    System.out.println("Digite um valor entre " + min + " e " + max + ".");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }
}
