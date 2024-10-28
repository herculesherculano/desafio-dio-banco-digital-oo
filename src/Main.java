
public class Main {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Hércules", "Rua Sete de Setembro, 231", "(83)99114-1468");
		
		Conta contaCorrente = new ContaCorrente(cliente);
		
		Conta contaPoupanca = new ContaPoupanca(cliente);
		
		contaCorrente.depositar(100);
		contaCorrente.depositar(50);
		contaCorrente.depositar(30);
		contaCorrente.sacar(20);
		contaCorrente.sacar(10);
		contaCorrente.sacar(70);
		
		contaCorrente.imprimirExtrato();
		
	}
	

}
