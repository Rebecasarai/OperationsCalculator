package examen;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Calcular extends JFrame implements ActionListener, ItemListener, KeyListener {
	private JTextField texto1, texto2,resultado;
	private Checkbox sumar, restar, multiplicar, dividir;
	private JButton limpiar, salir;
	private int con=0;
	
	public Calcular(){
		this.setTitle("Calcular");
		JPanel principal = new JPanel();
		principal.setLayout(new GridLayout(4, 1));
		//Numero 1 y 2
		JPanel arriba = new JPanel();
		arriba.setLayout(new GridLayout(2, 2));
		JLabel etiqueta = new JLabel("Numero 1");
		JLabel etiqueta2 = new JLabel("Numero 2");
		
		texto1 = new JTextField();
		texto2 = new JTextField();
		texto1.addKeyListener(this);
		texto2.addKeyListener(this);
		arriba.add(etiqueta);
		arriba.add(texto1);
		arriba.add(etiqueta2);
		arriba.add(texto2);
		
		principal.add(arriba);
		//Checkbox de Operaciones
		JPanel panel_operaciones = new JPanel();
		panel_operaciones.setLayout(new GridLayout(3, 3));
		CheckboxGroup operacion = new CheckboxGroup();
		sumar = new Checkbox("sumar", operacion, false);
		restar = new Checkbox("restar", operacion, false);
		multiplicar = new Checkbox("multiplicar", operacion, false);
		dividir = new Checkbox("dividir", operacion, false);
		
		sumar.addItemListener(this);
		restar.addItemListener(this);
		multiplicar.addItemListener(this);
		dividir.addItemListener(this);
		
		
		panel_operaciones.add(sumar);
		panel_operaciones.add(restar);
		panel_operaciones.add(multiplicar);
		panel_operaciones.add(dividir);
		principal.add(panel_operaciones);
		
		//Resultado
		JPanel panelr = new JPanel();
		panelr.setLayout(new GridLayout(1, 2));
		JLabel etiqueta_resul = new JLabel("Resultado");
		etiqueta_resul.setHorizontalAlignment(JLabel.RIGHT);
		resultado = new JTextField();
		resultado.setEditable(false);
		panelr.add(etiqueta_resul);
		panelr.add(resultado);
		
		principal.add(panelr);
		
		//Botones
		JPanel abajo = new JPanel();
		abajo.setLayout(new GridLayout(1, 2));
		limpiar = new JButton("Limpiar");
		limpiar.addActionListener(this);
		abajo.add(limpiar);
		salir = new JButton("Salir");
		salir.addActionListener(this);
		abajo.add(salir);
		
		principal.add(abajo);
		
		
		//Basicos
		this.add(principal);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new Calcular();

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		try{
		if (e.getItemSelectable().equals(sumar)) {
				double numero1 = Double.parseDouble(texto1.getText());
				double numero2 = Double.parseDouble(texto2.getText());
				
				double suma = numero1 + numero2;
				
				resultado.setText(""+suma);
				return;
			
		}
		if (e.getItemSelectable().equals(restar)) {
			double numero1 = Double.parseDouble(texto1.getText());
			double numero2 = Double.parseDouble(texto2.getText());
			double resta = numero1 - numero2;
			resultado.setText(""+resta);
			return;
		}
		if (e.getItemSelectable().equals(multiplicar)) {
			double numero1 = Double.parseDouble(texto1.getText());
			double numero2 = Double.parseDouble(texto2.getText());
			double suma = numero1 * numero2;
			
			resultado.setText(""+suma);
			return;
		}
		if (e.getItemSelectable().equals(dividir)) {
			double numero1 = Double.parseDouble(texto1.getText());
			double numero2 = Double.parseDouble(texto2.getText());
			double suma = numero1 / numero2;
			
			resultado.setText(""+suma);
			return;
		}
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Debe introducir solo numeros");
			resultado.setText("");
		}		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(limpiar)){
			resultado.setText("");
			texto1.setText("");
			texto2.setText("");
			return;
			
		}
		
		if(e.getSource().equals(salir)){
			System.exit(0);
		}
		
		
		
		
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		int tecla=(int)e.getKeyChar();
		if(tecla > 57|| tecla < 46||tecla==47){
			e.consume();
			Toolkit.getDefaultToolkit().beep(); 
		}
		if(tecla==46){
			if(con>0){
				e.consume();
				Toolkit.getDefaultToolkit().beep(); 
			}
			con++;
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
