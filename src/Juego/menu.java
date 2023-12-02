package Juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {
	//Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private preguntas val;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setResizable(false);
		//Ventana
		setTitle("Trivia de Matematicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Fondo
		
		JPanel textoInicio = new JPanel();
		textoInicio.setBounds(0, 0, 825, 441);
		textoInicio.setBackground(new Color(0, 128, 192));
		contentPane.add(textoInicio);
		textoInicio.setLayout(null);
		
		//Texto de bienvenida
		JLabel lblNewLabel = new JLabel("Trivia de Matematicas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 794, 60);
		textoInicio.add(lblNewLabel);
		
		//Boton de iniciacion
		JButton inicio = new JButton("INICIAR\r\n");
        inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Invoca la ventana donde esta el juego
                val = new preguntas();
                inicioDeJuego(val);
            }
        });
        inicio.setBackground(new Color(255, 128, 128));
        inicio.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
        inicio.setBounds(324, 138, 172, 143);
        textoInicio.add(inicio);
	}
	//Borra el JPanel actual para invocar otro
	private void inicioDeJuego(JPanel val1) {
        contentPane.removeAll();
        contentPane.add(val1);
        contentPane.repaint();
        contentPane.revalidate();
	}
}
