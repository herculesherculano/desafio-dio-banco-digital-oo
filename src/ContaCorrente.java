import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
		
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		System.out.println(new SimpleDateFormat().format(new Date()));
		super.imprimirInfosComuns();
		
	}

}
