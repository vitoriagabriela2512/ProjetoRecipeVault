
package br.ulbra.model;

public class ModoPreparo {
     private int idModoPreparo;   // PK
    private String descricao;    // ex: "Misture os ingredientes secos"
    private int ordem;           // posição do passo (1, 2, 3...)
    private int receitaId;       // FK: ID da receita à qual este passo pertence

    // Construtor padrão
    public ModoPreparo() {}

    // Construtor com parâmetros
    public ModoPreparo(int idModoPreparo, String descricao, int ordem, int receitaId) {
        this.idModoPreparo = idModoPreparo;
        this.descricao = descricao;
        this.ordem = ordem;
        this.receitaId = receitaId;
    }

    public int getIdModoPreparo() {
        return idModoPreparo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getOrdem() {
        return ordem;
    }

    public int getReceitaId() {
        return receitaId;
    }

    public void setIdModoPreparo(int idModoPreparo) {
        this.idModoPreparo = idModoPreparo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public void setReceitaId(int receitaId) {
        this.receitaId = receitaId;
    }

    @Override
    public String toString() {
        return "ModoPreparo{" + "idModoPreparo=" + idModoPreparo + ", descricao=" + descricao + ", ordem=" + ordem + ", receitaId=" + receitaId + '}';
    }
    
}
