package Blackjack;

import Blackjack.Utilidades;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Blackjack extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlCartasCrupier;
	private JPanel pnlCartasPlayer;
	private JButton btnPass;
	private JButton btnCatch;
	private JButton btnExit;
	private JButton btnReplay;
	private JLabel lblCarta;
	
	private carta cartaActual = Utilidades.nuevaCarta();
	private int puntosCrupier = 0;
	private int puntosPlayer = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Utilidades.generarCartas();
				
				
				try {
					Blackjack frame = new Blackjack();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Blackjack() {
		setResizable(false);
		setTitle("Blackjack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 550, 450);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		addElements();

	}

	public void addElements() {
		lblCarta = new JLabel("");
		lblCarta.setBounds(370, 5, 133, 174);
		lblCarta.setIcon(new ImageIcon("src/Blackjack/ImagenesCartas/reverso.png"));
		contentPane.add(lblCarta);
		
		pnlCartasCrupier = new JPanel();
		pnlCartasCrupier.setBounds(30, 20, 301, 162);
		contentPane.add(pnlCartasCrupier);
		pnlCartasCrupier.setLayout(new GridLayout(0,4));
		
		pnlCartasPlayer = new JPanel();
		pnlCartasPlayer.setBounds(30, 250, 301, 162);
		contentPane.add(pnlCartasPlayer);
		pnlCartasPlayer.setLayout(new GridLayout(0, 4));
		
		btnPass = new JButton("PASS");
		btnPass.setBounds(385, 207, 105, 27);
		btnPass.addActionListener(this);
		contentPane.add(btnPass);
		
		btnCatch = new JButton("CATCH");
		btnCatch.setBounds(385, 245, 105, 27);
		btnCatch.addActionListener(this);
		contentPane.add(btnCatch);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		
		btnReplay = new JButton("Replay");
		btnReplay.addActionListener(this);
		
		JLabel lblPlayer = new JLabel("You: ");
		lblPlayer.setBounds(30, 230, 49, 14);
		contentPane.add(lblPlayer);
		
		JLabel lblCrupier = new JLabel("Croupier: ");
		lblCrupier.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrupier.setBounds(201, 190, 58, 14);
		contentPane.add(lblCrupier);
		
		JTextField lblPuntosCrupier = new JTextField("0");
		lblPuntosCrupier.setEditable(false);
		lblPuntosCrupier.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosCrupier.setBounds(256, 190, 49, 14);
		contentPane.add(lblPuntosCrupier);
		
		guardarCarta(cartaActual, pnlCartasPlayer, cartaActual.getValor(), true);
	}
	
	public void actualizarPuntaje(int puntos, boolean turno) {
		if(turno) {
			puntosPlayer += puntos;
			JTextField lblPuntosPlayer = new JTextField((puntosPlayer)+ "");
			lblPuntosPlayer.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntosPlayer.setEditable(false);
			lblPuntosPlayer.setBounds(57, 230, 49, 14);
			contentPane.add(lblPuntosPlayer);

		}else {
			puntosCrupier += puntos;
			JTextField lblPuntosCrupier = new JTextField((puntosCrupier) + "");
			lblPuntosCrupier.setEditable(false);
			lblPuntosCrupier.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntosCrupier.setBounds(256, 190, 49, 14);
			contentPane.add(lblPuntosCrupier);
		}
	}
	
	public int cambiarValorAs(carta carta, int puntos) {
		if(carta.getValor() == 1 && puntos < 11) return 11;
		else return carta.getValor();
	}

	
	public void addCarta(carta cartaGuardada, JPanel panel) {
		panel.setLayout(new GridLayout(0, 4));
		JLabel lblCarta = new JLabel(new ImageIcon(cartaGuardada.getImagen()));
		panel.add(lblCarta);
		panel.revalidate();
		delay();
	}
	
	public void guardarCarta(carta cartaEntrada, JPanel panel, int puntos, boolean turno) {
		carta cartaSalida = cartaEntrada;
		
		addCarta(cartaSalida, panel);
		
		actualizarPuntaje(cambiarValorAs(cartaSalida, puntos), turno);
		
		cartaActual = Utilidades.nuevaCarta();
	}
	
	public void ganador() {
		if ((puntosCrupier == puntosPlayer) && puntosCrupier != 0) {
			JOptionPane.showMessageDialog(null, "Draw");
			System.exit(0);
		} 
		if (puntosPlayer == 21 || puntosCrupier == 21) {
			JOptionPane.showMessageDialog(null, "¡¡Blackjack!!");
			System.exit(0);
		} else if(puntosPlayer > 21) {
			JOptionPane.showMessageDialog(null, "You Lost");
			System.exit(0);
		}
		if ((puntosCrupier < 21 && puntosCrupier > puntosPlayer) || puntosPlayer > 21) {
			JOptionPane.showMessageDialog(null, "You Lost");
			System.exit(0);
		}else if(puntosCrupier > 21){
			JOptionPane.showMessageDialog(null, "¡¡You Win!!");
			System.exit(0);
		}
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPass) {
			for(int i = 1; puntosCrupier < 21; i++) {
				ganador();
				
				guardarCarta(cartaActual, pnlCartasCrupier, puntosCrupier, false);
				ganador();
			}
			actualizarPuntaje(puntosCrupier, rootPaneCheckingEnabled);
			
		}else if (e.getSource() == btnCatch) {
			guardarCarta(cartaActual, pnlCartasPlayer, puntosPlayer, true);
			ganador();

		}
		if (e.getSource() == btnReplay) {
			if (e.getSource() == btnPass) {
				for(int i = 1; puntosCrupier < 21; i++) {
					ganador();
					
					delay();
					guardarCarta(cartaActual, pnlCartasCrupier, puntosCrupier, false);
					delay();
				}
			}
		}
	}
	
	public void delay() {
		try {
			wait(1000);
		} catch(Exception e) {
			
		}
	}
}
