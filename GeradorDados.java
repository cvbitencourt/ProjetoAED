import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorDados {
    private static final String[] NOMES = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Jéssica", "Lucas", "Mariana", "Nicolas", "Patrícia", "Rafael", "Sabrina", "Thiago", "Vanessa", "Wagner", "Juliana"};
    private static final String[] ESTADOS = {"SP", "RJ", "MG", "ES", "RS", "PR", "SC"};
    private static final char[] SEXOS = {'M', 'F'};
    private static final char[] INTERESSES_SEXO = {'M', 'F', 'I'};

    public static void gerarArquivo(String nomeArquivo, int qtdCandidatos) {
        Random random = new Random();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write(qtdCandidatos + "\n");
            bw.write("****\n");

            for (int i = 0; i < qtdCandidatos; i++) {
                String nome = NOMES[random.nextInt(NOMES.length)] + " " + (i + 1);
                String estado = ESTADOS[random.nextInt(ESTADOS.length)];
                char sexo = SEXOS[random.nextInt(SEXOS.length)];
                char sexoInt = INTERESSES_SEXO[random.nextInt(INTERESSES_SEXO.length)];
                int numAreas = 1 + random.nextInt(4); // 1 a 4 áreas

                bw.write(nome + "\n");
                bw.write(estado + "\n");
                bw.write(sexo + "\n");
                bw.write(sexoInt + "\n");
                bw.write(numAreas + "\n");


                boolean[] areasEscolhidas = new boolean[9];
                for (int a = 0; a < numAreas; a++) {
                    int area;
                    do {
                        area = 1 + random.nextInt(8);
                    } while (areasEscolhidas[area]);
                    areasEscolhidas[area] = true;
                    bw.write(area + "\n");
                }
                bw.write("****\n");
            }
            System.out.println(">> Arquivo '" + nomeArquivo + "' gerado com sucesso com " + qtdCandidatos + " candidatos!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    }
}
