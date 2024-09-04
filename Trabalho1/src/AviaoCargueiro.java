import java.math.BigDecimal;

public class AviaoCargueiro {

    private Compartimento principal = new Compartimento();
    private Compartimento precioso = new Compartimento();
    private Compartimento auxiliar = new Compartimento();

    public AviaoCargueiro() {
        principal.setNome("Compartimento Principal");
        principal.setCapacidade(new BigDecimal("833"));
        
        precioso.setNome("Compartimento Precioso");
        precioso.setCapacidade(new BigDecimal("222"));
        
        auxiliar.setNome("Compartimento Auxiliar");
        auxiliar.setCapacidade(new BigDecimal("100")); // Defina a capacidade desejada para o auxiliar
    }

    public void armazenar(Caixa c) {
        BigDecimal pesoCaixa = c.getPeso();

        if (c.getTipo() == Caixa.TiposCaixa.PRECIOSO) {
            if (precioso.getCapacidade().compareTo(pesoCaixa) >= 0) {
                precioso.receber(c);
            } else {
                System.out.println("Não há espaço suficiente no Compartimento Precioso para esta caixa.");
            }
        } else if (c.getTipo() == Caixa.TiposCaixa.SIMPLES) {
            if (principal.getCapacidade().compareTo(pesoCaixa) >= 0) {
                principal.receber(c);
            } else if (auxiliar.getCapacidade().compareTo(pesoCaixa) >= 0) {
                auxiliar.receber(c);
            } else {
                System.out.println("Não há espaço suficiente no Compartimento Principal e no Auxiliar para esta caixa.");
            }
        } else {
            System.out.println("Tipo de caixa desconhecido.");
        }
    }

    public BigDecimal getCapacidadePrincipal() {
        return principal.getCapacidade();
    }

    public BigDecimal getCapacidadePrecioso() {
        return precioso.getCapacidade();
    }

    public BigDecimal getCapacidadeAuxiliar() {
        return auxiliar.getCapacidade();
    }

    public BigDecimal getPesoTotal() {
        return principal.getPesoArmazenado()
               .add(precioso.getPesoArmazenado())
               .add(auxiliar.getPesoArmazenado());
    }
}
