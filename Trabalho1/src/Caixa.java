
import java.math.BigDecimal;
public class Caixa {
	
	
	public enum TiposCaixa {
	SIMPLES, PRECIOSO;
}
	private TiposCaixa tipo;
	private BigDecimal peso;
	
	
	public TiposCaixa getTipo() {
		return tipo;
	}
	public void setTipo(TiposCaixa tipo) {
		this.tipo = tipo;
	}
	
	
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

}

