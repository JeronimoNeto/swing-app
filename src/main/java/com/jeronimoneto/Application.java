package com.jeronimoneto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Application {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new BorderLayout());

		JLabel titulo = new JLabel("<html><h1>Tela de Cadastro de Produtos</h1></div></html>");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		frame.add(titulo, BorderLayout.NORTH);

		TelaDeCadastroDeProdutos telaDeCadastroDeProdutos = new TelaDeCadastroDeProdutos();
		frame.add(telaDeCadastroDeProdutos);
	}

}
