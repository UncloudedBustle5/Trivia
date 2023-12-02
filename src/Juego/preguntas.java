package Juego;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class preguntas extends JPanel {

    private static final long serialVersionUID = 1L;

    //variables
    private JLabel pregunta;
    private JPanel barra;
    private int numero1, numero2, respuestaCorrecta = 0;
    private String operacion, contador;
    private JTextField contenedorDeRespuesta;
    private JButton enviarRespuesta;
    private JLabel lblRespuestaIncorrecta;
    private JLabel error;
    //Getters and Setters
    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public String getContador() {
		return contador;
	}

	public void setContador(String contador) {
		this.contador = contador;
	}

	//Tipo de operacion que va a hacer
    public String operador() {
        int numeroDeOperacion;
        numeroDeOperacion = (int) (Math.random() * 2 + 1);
        if (numeroDeOperacion == 1) {
            operacion = "+";
        } else if (numeroDeOperacion == 2) {
            operacion = "-";
        }
        return operacion;
    }

    //Generador de numeros aleatorios y respuesta correcta
    public void respuesta() {
        numero1 = (int) (Math.random() * 100 + 0);
        numero2 = (int) (Math.random() * 100 + 0);
        if (operacion.equals("+")) {
        	System.out.println("Suma");
            respuestaCorrecta = numero1 + numero2;
        } else if (operacion.equals("-")) {
        	System.out.println("Resta");
            respuestaCorrecta = numero1 - numero2;
        }
    }

    //formulario
    public preguntas() {
    	setBackground(new Color(255, 255, 255));
        setOperacion(operador());
        respuesta();
        setRespuestaCorrecta(getRespuestaCorrecta());
        //Hace visible y le da un tamaño a el JPanel 
        this.setSize(825, 441);
        this.setVisible(true);
        //barra de las preguntas
        setLayout(null);
        barra = new JPanel();
        barra.setBackground(new Color(0, 128, 255));
        barra.setBounds(0, 0, 825, 120);
        add(barra);
        barra.setLayout(null);
        //Pregunta
        pregunta = new JLabel("Cuanto es " + getNumero1() + getOperacion() + getNumero2() + " ?");
        pregunta.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta.setForeground(new Color(255, 255, 255));
        pregunta.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 22));
        pregunta.setBounds(194, 22, 440, 76);
        barra.add(pregunta);
        //Cuenta los puntos
        JLabel contadorDePuntos = new JLabel("0");
        contadorDePuntos.setHorizontalAlignment(SwingConstants.CENTER);
        contadorDePuntos.setForeground(new Color(255, 255, 255));
        contadorDePuntos.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 25));
        contadorDePuntos.setBounds(673, 18, 152, 57);
        barra.add(contadorDePuntos);
        
        JLabel lblNewLabel_1 = new JLabel("Puntos");
        lblNewLabel_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(719, 69, 72, 14);
        barra.add(lblNewLabel_1);
        //Panel para colocar la respuesta
        contenedorDeRespuesta = new JTextField();
        contenedorDeRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
        contenedorDeRespuesta.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 25));
        contenedorDeRespuesta.setBounds(240, 159, 357, 79);
        add(contenedorDeRespuesta);
        contenedorDeRespuesta.setColumns(10);
        //Boton para enviar la respuesta
        enviarRespuesta = new JButton("Enviar");
        enviarRespuesta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			//Obtiene el texto y lo transforma en un valor entero
            		String respuestaText=contenedorDeRespuesta.getText();
            		int respuestaNum=Integer.parseInt(respuestaText);
            		if(respuestaNum==respuestaCorrecta) {
            			//Si la respuesta es correcta se genera otra pregunta
            			System.out.println("Correcto");
            			setOperacion(operador());
            			respuesta();
            			setRespuestaCorrecta(getRespuestaCorrecta());
            			error.setText(" ");
            			/*Se obtiene el texto de JLabel llamado puntos para sumarle los puntos ganados y despues
            			 * lo vuelve a transformar en un String para actualizar el JLabel; Se actualiza la nueva pregunta
            			 */
            			String puntos2=contadorDePuntos.getText();
                		int puntos=Integer.parseInt(puntos2);
                        puntos=puntos+75;
                        String puntos3=Integer.toString(puntos);
                        contadorDePuntos.setText(puntos3);
                        pregunta.setText("Cuanto es " + getNumero1() + getOperacion() + getNumero2() + " ?");
            		}else {
            			//Si la respuesta es incorrecta se genera otra pregunta
            			System.out.println("Incorrecto");
            			setOperacion(operador());
                        respuesta();
                        setRespuestaCorrecta(getRespuestaCorrecta());
                        error.setText(" ");
                        /*Se obtiene el texto de JLabel llamado puntos para sumarle los puntos ganados y despues
            			 * lo vuelve a transformar en un String para actualizar el JLabel; Se actualiza la nueva pregunta
            			 */
                        String puntos2=contadorDePuntos.getText();
                		int puntos=Integer.parseInt(puntos2);
                        puntos=puntos+25;
                        String puntos3=Integer.toString(puntos);
                        contadorDePuntos.setText(puntos3);
                        pregunta.setText("Cuanto es " + getNumero1() + getOperacion() + getNumero2() + " ?");
                        
            		}
            		}catch (NumberFormatException nfe) {
                        error.setText("Error: la respuesta no es un número.");
                        return;
            		}
        	}	
        });
        enviarRespuesta.setBackground(new Color(255, 128, 128));
        enviarRespuesta.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
        enviarRespuesta.setBounds(327, 299, 179, 72);
        add(enviarRespuesta);    
        //Indicaciones de puntos ganados
        JLabel lblNewLabel = new JLabel("Respuesta Correcta = +75 puntos");
        lblNewLabel.setBounds(600, 380, 215, 30);
        add(lblNewLabel);
        
        lblRespuestaIncorrecta = new JLabel("Respuesta Incorrecta = +25 puntos");
        lblRespuestaIncorrecta.setBounds(600, 411, 215, 30);
        add(lblRespuestaIncorrecta);
        //Mensaje de error
        error = new JLabel("  ");
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 15));
        error.setForeground(Color.RED);
        error.setBounds(240, 249, 357, 22);
        add(error);
  }
}