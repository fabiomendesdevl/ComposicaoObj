package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrdemStatus;

public class Ordem {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private OrdemStatus status;
	
	private Cliente cliente; //tem 1 
	public List<OrdemItem> items = new ArrayList<OrdemItem>(); //Coleção pra guardar >> itens

	
	public Ordem() {
		
	}

	public Ordem(Date momento, OrdemStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

/*	public List<OrdemItem> getItems() {
		return items;
	}
	public void setItems(List<OrdemItem> items) {
		
	}*/

	public void addItems(OrdemItem item) {
		items.add(item);
	}
	public void removeItems(OrdemItem item) {
		items.remove(item);
	}
	
	//duvida
	public double total() {
		double soma = 0.0;
		for (OrdemItem it : items) {
			soma = soma + it.subTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ordem momento: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Ordem Status: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Ordem items: \n");
		for(OrdemItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("preço total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}