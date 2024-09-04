import java.math.BigDecimal;

public class Compartimento {

    private BigDecimal capacidade;
    private String nome;
    private BigDecimal pesoArmazenado = new BigDecimal("0"); // Peso armazenado

    public void receber(Caixa x) {
        this.capacidade = this.capacidade.subtract(x.getPeso()); // Reduz a capacidade
        this.pesoArmazenado = this.pesoArmazenado.add(x.getPeso()); // Aumenta o peso armazenado
    }

    public BigDecimal getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(BigDecimal capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPesoArmazenado() {
        return pesoArmazenado;
    }
}