import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorAgencia gerenciador = new GerenciadorAgencia();

        System.out.println("=== SISTEMA DE GERENCIAMENTO DE AGÊNCIA DE RELACIONAMENTO ===");

        
        GeradorDados.gerarArquivo("candidatos.txt", 15);
        gerenciador.carregarCandidatos("candidatos.txt");
  int opcao = 0;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Inserir/atualizar o grau de interesse desejado");
            System.out.println("2. Consultar potenciais companheiros de um candidato");
            System.out.println("3. Imprimir Top K candidatos com mais companheiros");
            System.out.println("4. Imprimir candidatos sem companheiros");
            System.out.println("5. Imprimir candidatos com interesse em uma área");
            System.out.println("6. Imprimir candidatos residentes em um estado");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                scanner.next();
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo grau de interesse desejado (ex: 6): ");
                    int novoGrau = scanner.nextInt();
                    gerenciador.setGrauInteresse(novoGrau);
                    break;
                case 2:
                    System.out.print("Digite o ID do candidato (0 a " + (gerenciador.getTotalCandidatos() - 1) + "): ");
                    int idCand = scanner.nextInt();
                    gerenciador.tarefa2(idCand);
                    break;
                case 3:
                    System.out.print("Digite o valor de K: ");
                    int k = scanner.nextInt();
                    gerenciador.tarefa3(k);
                    break;
                case 4:
                    gerenciador.tarefa4();
                    break;
                case 5:
                    System.out.println("Áreas: 1: ESPORTES, 2: ARTES, 3: MÚSICA, 4: CINEMA, 5: TECNOLOGIA, 6: ANIMAIS, 7: GASTRONOMIA, 8: CIÊNCIAS");
                    System.out.print("Digite o código da área de interesse: ");
                    int area = scanner.nextInt();
                    gerenciador.tarefa5(area);
                    break;
                case 6:
                    System.out.print("Digite a sigla do estado (ex: SP, MG): ");
                    String estado = scanner.next();
                    gerenciador.tarefa6(estado);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
