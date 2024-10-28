import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		System.out.println(new SimpleDateFormat().format(new Date()));
		super.imprimirInfosComuns();
		
	}

}
