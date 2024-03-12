package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemItem;
import entities.Produto;
import entities.enums.OrdemStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira o nome do cliente: ");
		String nome = sc.nextLine();
		System.out.print("Insira o email do cliente: ");
		String email = sc.next();
		System.out.print("Insira a data de nascimento: ");
		Date date = sdf.parse(sc.next());

		Cliente cliente = new Cliente(nome, email, date);

		System.out.println("Dados do pedido");
		System.out.print("Status: ");
		OrdemStatus status = OrdemStatus.valueOf(sc.next()); // detalhe

		Ordem ordem = new Ordem(new Date(), status, cliente);  //instacia o order associado ao cliente
		
		System.out.print("Informe quantos itens: "); // quantidade de itens crie um for
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Insira os dados do item  [" + i +"]");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String produtoNome = sc.nextLine();
			System.out.print("Preço do produto: ");
			double produtoPreco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			Produto produto = new Produto(produtoNome, produtoPreco); // instacia o produto
			OrdemItem it = new OrdemItem(quantidade, produtoPreco, produto); // agora esta associado a produto
																			////agora o item de pedido associado a esse produto
			ordem.addItems(it);
		}
		System.out.println();
		System.out.println(ordem);

		sc.close();
	}

}
