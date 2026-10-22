public class Candidato {
    private int identificador;
    private String nome;
    private String siglaEstado;
    private char sexo;          
    private char sexoInteresse;  
    private ListaIdentificadores interesses;
    private ListaIdentificadores potenciaisCompanheiros;

    public Candidato(int identificador, String nome, String siglaEstado, char sexo, char sexoInteresse) {
        this.identificador = identificador;
        this.nome = nome;
        this.siglaEstado = siglaEstado;
        this.sexo = sexo;
        this.sexoInteresse = sexoInteresse;
        this.interesses = new ListaIdentificadores();
        this.potenciaisCompanheiros = new ListaIdentificadores();
    }

    public void adicionarInteresse(int idArea) {
        this.interesses.inserir(idArea);
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public char getSexo() {
        return sexo;
    }

    public char getSexoInteresse() {
        return sexoInteresse;
    }

    public ListaIdentificadores getInteresses() {
        return interesses;
    }

    public ListaIdentificadores getPotenciaisCompanheiros() {
        return potenciaisCompanheiros;
    }
    public void setNome(String nome) { this.nome = nome; }

    public void setSiglaEstado(String sigla) { this.siglaEstado = sigla; }

    public void setSexo(char sexo) { this.sexo = sexo; }

    public void setSexoInteresse(char s) { this.sexoInteresse = s; }

    
    public boolean reside(String sigla) {
        return this.siglaEstado.equalsIgnoreCase(sigla);
    }

    public boolean temInteresse(int idArea) {
        return this.interesses.contem(idArea);
    }

    public int numeroCompanheiros() {
        return this.potenciaisCompanheiros.getTamanho();
    }

    public ListaIdentificadores listaCompanheiros() {
        return this.potenciaisCompanheiros;
    }

    public void inserePotencialCompanheiro(Candidato v) {
        this.potenciaisCompanheiros.inserir(v.getIdentificador());
    }

    public static boolean verificaPotencialCompanheiro(Candidato u, Candidato v, int grauMinimo) {
        if (u.getIdentificador() == v.getIdentificador()) return false;

        
        if (!u.reside(v.getSiglaEstado())) return false;

       
        boolean uAtendeV = (u.getSexoInteresse() == 'I' || u.getSexoInteresse() == v.getSexo());
        boolean vAtendeU = (v.getSexoInteresse() == 'I' || v.getSexoInteresse() == u.getSexo());
        if (!uAtendeV || !vAtendeU) return false;

        
        int grauComum = 0;
        for (int i = 0; i < u.getInteresses().getTamanho(); i++) {
            int areaU = u.getInteresses().obter(i);
            if (v.temInteresse(areaU)) {
                grauComum += calcularPesoArea(areaU);
            }
        }

        return grauComum >= grauMinimo;
    }
    public void limparPotenciaisCompanheiros() {
    potenciaisCompanheiros.limpar();
}

    private static int calcularPesoArea(int idArea) {
        switch (idArea) {
            case 1: 
            case 3: 
            case 4: 
                return 1;
            case 2: 
            case 6: 
            case 7: 
                return 2;
            case 5: 
            case 8: 
                return 3;
            default:
                return 1;
        }
    }
}
