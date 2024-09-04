import java.math.BigDecimal;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        
        AviaoCargueiro aviao = new AviaoCargueiro(); // Certifique-se de que a classe AviaoCargueiro esteja implementada
        Scanner entrada = new Scanner(System.in);
        
        boolean continuar = true;

        while (continuar) {
            Caixa carga = new Caixa();

            System.out.println("Informe o tipo da caixa (Simples ou Precioso):");
            String tipoEntrada = entrada.nextLine();
            try {
                Caixa.TiposCaixa tipoCaixa = Caixa.TiposCaixa.valueOf(tipoEntrada.toUpperCase());
                carga.setTipo(tipoCaixa);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de caixa inválido. Tente novamente.");
                continue; // Vai para o próximo loop sem perguntar "Deseja colocar mais uma caixa?"
            }

            System.out.println("Informe o peso da caixa:");
            carga.setPeso(entrada.nextBigDecimal());
            entrada.nextLine(); // Consumir a nova linha após o número
            
            // Armazenar a caixa no avião
            aviao.armazenar(carga);

            // Exibir o peso atual disponível nos compartimentos
            System.out.println("Peso disponível no Compartimento Principal: " + aviao.getCapacidadePrincipal());
            System.out.println("Peso disponível no Compartimento Precioso: " + aviao.getCapacidadePrecioso());
            System.out.println("Peso disponível no Compartimento Auxiliar: " + aviao.getCapacidadeAuxiliar());
            
            // Exibir o peso total armazenado
            System.out.println("Peso total armazenado: " + aviao.getPesoTotal() + " kg");
            
            System.out.println("Deseja colocar mais uma caixa? (s/n)");
            String resposta = entrada.nextLine();
 
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        // Verificar se o avião pode decolar
        BigDecimal pesoTotal = aviao.getPesoTotal();
        if (pesoTotal.compareTo(new BigDecimal("500")) >= 0) {
            System.out.println("O avião pode decolar. Peso total armazenado: " + pesoTotal + " kg");
        } else {
            System.out.println("O avião não pode decolar. Peso total armazenado: " + pesoTotal + " kg. Necessário um mínimo de 500 kg.");
        }

        entrada.close();
    }
}
