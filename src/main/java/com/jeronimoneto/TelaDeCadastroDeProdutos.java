package com.jeronimoneto;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.jeronimoneto.model.Produtos;

public class TelaDeCadastroDeProdutos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1673488987387524863L;
	private List<Produtos> produtos = new ArrayList<>();

	public TelaDeCadastroDeProdutos() {
		// GridLayout simula uma tabela com duas colunas
		this.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel nomeDoProduto = new JLabel("Nome do Produto");
		nomeDoProduto.setHorizontalAlignment(JLabel.RIGHT);
		this.add(nomeDoProduto);

		JTextField nomeDoProdutoField = new JTextField();
		this.add(nomeDoProdutoField);

		JLabel quantidade = new JLabel("Quantidade");
		quantidade.setHorizontalAlignment(JLabel.RIGHT);
		this.add(quantidade);

		JTextField quantidadeField = new JTextField();
		this.add(quantidadeField);

		JLabel valorUnitario = new JLabel("Valor Unitário");
		valorUnitario.setHorizontalAlignment(JLabel.RIGHT);
		this.add(valorUnitario);

		JTextField valorUnitarioField = new JTextField();
		this.add(valorUnitarioField);

		JButton btnAdicionar = new JButton("Adicionar");
		this.add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String nome = StringUtils.capitalize(nomeDoProdutoField.getText());
				int quantidade = Integer.parseInt(quantidadeField.getText());
				double valorUnitario = Double.parseDouble(valorUnitarioField.getText());

				Produtos produto = new Produtos(nome, quantidade, valorUnitario);
				produtos.add(produto);
				System.out.println();

				nomeDoProdutoField.setText("");
				quantidadeField.setText("");
				valorUnitarioField.setText("");

			}
		});

		JButton btnmostrarTodos = new JButton("Mostrar Todos");
		this.add(btnmostrarTodos);
		btnmostrarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < produtos.size(); i++) {
					System.out.println(produtos.get(i));
				}

				Object[] colunas = { "Nome", "Quantidade", "Valor", "Total" };
				Object[][] linhas = new Object[produtos.size() + 2][4];
				for (int i = 0; i < produtos.size(); i++) {
					Object[] linha = new Object[] { produtos.get(i).getNome().toUpperCase(),
							produtos.get(i).getQuantidade(), produtos.get(i).getValorUnitario(),
							produtos.get(i).getValorUnitario() * produtos.get(i).getQuantidade() };
					linhas[i] = linha;
				}

				int somaQuantidade = 0;
				double totalValorGeral = 0;

				for (Produtos produto : produtos) {
					somaQuantidade += produto.getQuantidade();
					totalValorGeral = totalValorGeral + (produto.getQuantidade() * produto.getValorUnitario());

				}
				linhas[produtos.size() + 1] = new Object[] { "TOTAL", somaQuantidade, "", totalValorGeral };

				JTable tabela = new JTable(linhas, colunas);

				JScrollPane jscroll = new JScrollPane(tabela);
				jscroll.setSize(new Dimension(500, 500));

				JOptionPane.showMessageDialog(null, new JScrollPane(tabela));
			}
		});
	}
}
