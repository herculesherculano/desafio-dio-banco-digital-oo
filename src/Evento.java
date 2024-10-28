import java.text.SimpleDateFormat;

public class Evento {
	
	private String tipoEvento;
	private String data;
	private double valor;
	
	Evento(String tipoEvento, String data, double valor) {
		this.tipoEvento= tipoEvento;
		this.data=data;
		this.valor=valor;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return  data + "    " + tipoEvento + "    " + String.format("%.2f", this.valor) + "\n";
	}
	
	
}
