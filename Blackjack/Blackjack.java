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
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class Blackjack extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValorArriba;
	private JTextField txtValorAbajo;
	private JTextField txtColor;
	private JPanel pnlCartasCrupier;
	private JPanel pnlCartasPlayer;
	private JButton btnPass;
	private JButton btnCatch;
	private JLabel lblPuntosCrupier;
	private JLabel lblPuntosPlayer;
	
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
		setResizable(true);
		setTitle("Blackjack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 350);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		ponerCarta();
		
		pnlCartasCrupier = new JPanel();
		pnlCartasCrupier.setBounds(30, 20, 265, 115);
		contentPane.add(pnlCartasCrupier);
		pnlCartasCrupier.setLayout(new GridLayout(4,0));
		
		pnlCartasPlayer = new JPanel();
		pnlCartasPlayer.setBounds(30, 190, 265, 115);
		contentPane.add(pnlCartasPlayer);
		pnlCartasPlayer.setLayout(new GridLayout(4, 0));
		
		btnPass = new JButton("PASS");
		btnPass.setBounds(313, 206, 105, 27);
		btnPass.addActionListener(this);
		contentPane.add(btnPass);
		
		btnCatch = new JButton("CATCH");
		btnCatch.setBounds(313, 245, 105, 27);
		btnCatch.addActionListener(this);
		contentPane.add(btnCatch);
		
		JLabel lblPlayer = new JLabel("Tu: ");
		lblPlayer.setBounds(30, 171, 49, 14);
		contentPane.add(lblPlayer);
		
		JTextField lblPuntosPlayer = new JTextField(puntosPlayer + "");
		lblPuntosPlayer.setBounds(57, 171, 49, 14);
		contentPane.add(lblPuntosPlayer);
		
		JLabel lblCrupier = new JLabel("Crupier: ");
		lblCrupier.setBounds(201, 149, 58, 14);
		contentPane.add(lblCrupier);
		
		JTextField lblPuntosCrupier = new JTextField(puntosCrupier + "");
		lblPuntosCrupier.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosCrupier.setBounds(236, 149, 49, 14);
		contentPane.add(lblPuntosCrupier);
		

	}

	public void ponerCarta() {
		txtValorAbajo = new JTextField(cartaActual.getValor() + "");
		txtValorAbajo.setCaretColor(new Color(0, 0, 0));
		txtValorAbajo.setEditable(false);
		txtValorAbajo.setColumns(10);
		txtValorAbajo.setBounds(400, 149, 30, 30);
		contentPane.add(txtValorAbajo);
		
		txtValorArriba = new JTextField(cartaActual.getValor() + "");
		txtValorArriba.setCaretColor(new Color(0, 0, 0));
		txtValorArriba.setEditable(false);
		txtValorArriba.setColumns(10);
		txtValorArriba.setBounds(297, 5, 30, 30);
		contentPane.add(txtValorArriba);
		
		txtColor = new JTextField(cartaActual.getNombre());
		txtColor.setCaretColor(new Color(0, 0, 0));
		txtColor.setHorizontalAlignment(SwingConstants.CENTER);
		txtColor.setEditable(false);
		txtColor.setBounds(313, 80, 104, 21);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
	}

	public void guardarCarta(carta cartaGuardada, JPanel panel) {
		txtValorAbajo = new JTextField(cartaGuardada.getValor() + "");
		txtValorAbajo.setFont(new Font("Dialog", Font.PLAIN, 8));
		txtValorAbajo.setCaretColor(new Color(0, 0, 0));
		txtValorAbajo.setEditable(false);
		txtValorAbajo.setColumns(10);
		txtValorAbajo.setBounds(59, 100, 15, 15);
		panel.add(txtValorAbajo);
		
		
		txtValorArriba = new JTextField(cartaGuardada.getValor() + "");
		txtValorArriba.setFont(new Font("Dialog", Font.PLAIN, 8));
		txtValorArriba.setCaretColor(new Color(0, 0, 0));
		txtValorArriba.setEditable(false);
		txtValorArriba.setColumns(10);
		txtValorArriba.setBounds(0, 0, 15, 15);
		panel.add(txtValorArriba);
		
		txtColor = new JTextField(cartaGuardada.getNombre());
		txtColor.setFont(new Font("Dialog", Font.PLAIN, 8));
		txtColor.setCaretColor(new Color(0, 0, 0));
		txtColor.setHorizontalAlignment(SwingConstants.CENTER);
		txtColor.setEditable(false);
		txtColor.setBounds(12, 49, 50, 21);
		txtColor.setColumns(10);
		panel.add(txtColor);
		
	}
	
	public void actualizarPuntaje() {
		JTextField lblPuntosPlayer = new JTextField(puntosPlayer + "");
		lblPuntosPlayer.setBounds(57, 171, 49, 14);
		contentPane.add(lblPuntosPlayer);
		
		JTextField lblPuntosCrupier = new JTextField(puntosCrupier + "");
		lblPuntosCrupier.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosCrupier.setBounds(236, 149, 49, 14);
		contentPane.add(lblPuntosCrupier);
	}
	
	public void ganador() {
		if (puntosCrupier == 21 || (puntosCrupier < 21 && puntosCrupier > puntosPlayer) || puntosPlayer > 21) {
			JOptionPane.showMessageDialog(null, "Gana la casa");
			System.exit(0);
		}else if (puntosPlayer == 21 || ((puntosPlayer < 21 && puntosPlayer > puntosCrupier) || puntosCrupier > 21) && puntosCrupier != 0) {
			JOptionPane.showMessageDialog(null, "¡¡Ganaste!!");
			System.exit(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPass) {
			while(puntosCrupier < 22) {
				carta cartaCrupier = cartaActual;
				
				puntosCrupier += cartaCrupier.getValor();
				
				guardarCarta(cartaCrupier, pnlCartasCrupier);
			}
			
		}else if (e.getSource() == btnCatch) {
			carta cartaPlayer = cartaActual;
			
			puntosPlayer += cartaPlayer.getValor();
			
			guardarCarta(cartaPlayer, pnlCartasPlayer);
		}
		
		cartaActual = Utilidades.nuevaCarta();
		
		actualizarPuntaje();
		
		ponerCarta();

		ganador();
		
		System.out.println(puntosCrupier + " y " + puntosPlayer);
	}
}
