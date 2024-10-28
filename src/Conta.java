import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL =1;
	
	protected int agencia;
	protected int numeroConta;
	protected Cliente cliente;
	protected double saldo=0;
	
	protected List<Evento> eventosList;
	
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
		this.eventosList=new ArrayList<>();
	}
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	
	
	@Override
	public void sacar(double valorSaque) {
		if(saldo>=valorSaque) {
			saldo=saldo-valorSaque;
			eventosList.add(new Evento("Saque", new SimpleDateFormat().format(new Date()), valorSaque));
		}else {
			throw new RuntimeException("Saldo Insuficiente");
		}
		
	}
	
	@Override
	public void depositar(double valorDeposito) {
		saldo=saldo+valorDeposito;
		eventosList.add(new Evento("Depósito", new SimpleDateFormat().format(new Date()), valorDeposito));
		
	}
	@Override
	public void transferir(double valorTransferencia, IConta contaDestino) {
		if(saldo>=valorTransferencia) {
			saldo=saldo-valorTransferencia;
			contaDestino.depositar(valorTransferencia);
			eventosList.add(new Evento("Transf. Enviada", new SimpleDateFormat().format(new Date()), valorTransferencia));
		}else {
			throw new RuntimeException("Saldo Insuficiente para realiazar transferência");
		}
		
	}
	
	public void imprimirInfosComuns() {
		System.out.print(String.format("Agencia: %d     " , this.agencia));
		System.out.println(String.format("Conta: %d ", this.numeroConta));
		System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
		eventosList.forEach(System.out::print);
		//System.out.println(eventosList);
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
}
