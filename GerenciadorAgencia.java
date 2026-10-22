import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorAgencia {
    private Candidato[] candidatos;
    private int totalCandidatos;
    private int grauInteresseDesejado = 6; 

    public void carregarCandidatos(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine();
            if (linha == null) return;
            totalCandidatos = Integer.parseInt(linha.trim());
            candidatos = new Candidato[totalCandidatos];

            br.readLine();
            
            for (int i = 0; i < totalCandidatos; i++) {
                String nome = br.readLine().trim();
                String estado = br.readLine().trim();
                char sexo = br.readLine().trim().toUpperCase().charAt(0);
                char sexoInteresse = br.readLine().trim().toUpperCase().charAt(0);
                int numAreas = Integer.parseInt(br.readLine().trim());

                Candidato c = new Candidato(i, nome, estado, sexo, sexoInteresse);

                for (int j = 0; j < numAreas; j++) {
                    int idArea = Integer.parseInt(br.readLine().trim());
                    c.adicionarInteresse(idArea);
                }

                candidatos[i] = c;
                br.readLine(); 
            }

            processarPotenciaisCompanheiros();
            System.out.println(">> Arquivo carregado e potenciais companheiros calculados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

 public void processarPotenciaisCompanheiros() {
    for (int i = 0; i < totalCandidatos; i++)
        candidatos[i].limparPotenciaisCompanheiros();
    for (int i = 0; i < totalCandidatos; i++)
        for (int j = 0; j < totalCandidatos; j++)
            if (Candidato.verificaPotencialCompanheiro(candidatos[i], candidatos[j], grauInteresseDesejado))
                candidatos[i].inserePotencialCompanheiro(candidatos[j]);
}

    
    public void setGrauInteresse(int grau) {
        this.grauInteresseDesejado = grau;
        processarPotenciaisCompanheiros();
        System.out.println(">> Grau de interesse atualizado para " + grau + " e pares recalculados.");
    }

    
    public void tarefa2(int idCandidato) {
        if (idCandidato < 0 || idCandidato >= totalCandidatos) {
            System.out.println("ID de candidato inválido.");
            return;
        }
        Candidato c = candidatos[idCandidato];
        System.out.println("\nCandidato: ID " + c.getIdentificador() + " - " + c.getNome());
        System.out.println("Número de potenciais companheiros: " + c.numeroCompanheiros());
        System.out.println("Lista de Companheiros:");
        ListaIdentificadores lista = c.listaCompanheiros();
        for (int i = 0; i < lista.getTamanho(); i++) {
            int idComp = lista.obter(i);
            System.out.println(" - ID: " + idComp + " | Nome: " + candidatos[idComp].getNome());
        }
    }

    
public void tarefa3(int k) {
    System.out.println("\n--- Top " + k + " Candidatos com Maior Número de Companheiros ---");

    if (k <= 0) {
        System.out.println("K deve ser maior que zero.");
        return;
    }

    int[] ids = new int[totalCandidatos];
    for (int i = 0; i < totalCandidatos; i++) ids[i] = i;

    int limite = Math.min(k, totalCandidatos);
    for (int i = 0; i < limite; i++) {
        int melhor = i;
        for (int j = i + 1; j < totalCandidatos; j++)
            if (candidatos[ids[j]].numeroCompanheiros() > candidatos[ids[melhor]].numeroCompanheiros())
                melhor = j;
        int temp = ids[i]; ids[i] = ids[melhor]; ids[melhor] = temp;
    }

    for (int i = 0; i < limite; i++) {
        Candidato c = candidatos[ids[i]];
        System.out.println((i + 1) + ". ID: " + c.getIdentificador() + " | Nome: " + c.getNome() + " | Companheiros: " + c.numeroCompanheiros());
    }
}

   
    public void tarefa4() {
        System.out.println("\n--- Candidatos Sem Nenhum Companheiro ---");
        boolean encontrou = false;
        for (int i = 0; i < totalCandidatos; i++) {
            if (candidatos[i].numeroCompanheiros() == 0) {
                System.out.println(" - ID: " + candidatos[i].getIdentificador() + " | Nome: " + candidatos[i].getNome());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum candidato ficou sem companheiros.");
    }

   
    public void tarefa5(int idArea) {
        System.out.println("\n--- Candidatos com Interesse na Área " + idArea + " ---");
        boolean encontrou = false;
        for (int i = 0; i < totalCandidatos; i++) {
            if (candidatos[i].temInteresse(idArea)) {
                System.out.println(" - ID: " + candidatos[i].getIdentificador() + " | Nome: " + candidatos[i].getNome());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum candidato encontrado para esta área.");
    }

   
    public void tarefa6(String siglaEstado) {
        System.out.println("\n--- Candidatos Residente em " + siglaEstado.toUpperCase() + " ---");
        boolean encontrou = false;
        for (int i = 0; i < totalCandidatos; i++) {
            if (candidatos[i].reside(siglaEstado)) {
                System.out.println(" - ID: " + candidatos[i].getIdentificador() + " | Nome: " + candidatos[i].getNome());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum candidato encontrado neste estado.");
    }

    public int getTotalCandidatos() {
        return totalCandidatos;
    }
    private static int lerInt(Scanner sc, String msg) {
    while (true) {
        System.out.print(msg);
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Digite um número inteiro."); }
    }
}
}
