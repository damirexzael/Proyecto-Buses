import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;


public class FrameMostrarLugares extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableLugares;
	private JTextField textFieldBorrar;
	private JTextField textFieldEditar;

	/**
	 * Create the frame.
	 */
	public FrameMostrarLugares(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLugares = new JLabel("Lugares");
		lblLugares.setBounds(78, 24, 75, 14);
		panel.add(lblLugares);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 192, 192);
		panel.add(scrollPane);
		
		tableLugares = new JTable();
		tableLugares.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id" , "Lugar"
			}
		));
		scrollPane.setViewportView(tableLugares);
		
		JButton button = new JButton("Volver al Menu Principal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameMostrarLugares.this.dispose();
			}
		});
		button.setBounds(266, 0, 158, 23);
		panel.add(button);
		
		textFieldBorrar = new JTextField();
		textFieldBorrar.setBounds(229, 221, 86, 20);
		panel.add(textFieldBorrar);
		textFieldBorrar.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldBorrar.getText().equals(""))
					JOptionPane.showMessageDialog(null, "No has ingresado numero aun.");
				else {
					try {
						Lugar lugares[] = agencia.listarLugares();
						if(Integer.parseInt(textFieldBorrar.getText()) < 1 
								&& Integer.parseInt(textFieldBorrar.getText()) > lugares.length)
							JOptionPane.showMessageDialog(null, "Numero fuera del rango.");
						else {
							Lugar lugarBorrar = agencia.listarLugares()[Integer.parseInt(textFieldBorrar.getText()) - 1];
							if(agencia.borrarLugar(lugarBorrar)!=null) {
	
								FrameMostrarLugares frame = new FrameMostrarLugares(agencia);
								frame.setVisible(true);
								FrameMostrarLugares.this.dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Error al borrar ese lugar.");
						}
					}
					catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Solamente se permiten numeros.");
					}
				}
			}
		});
		btnEliminar.setBounds(325, 220, 89, 23);
		panel.add(btnEliminar);
		
		textFieldEditar = new JTextField();
		textFieldEditar.setColumns(10);
		textFieldEditar.setBounds(229, 184, 86, 20);
		panel.add(textFieldEditar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldBorrar.getText().equals(""))
					JOptionPane.showMessageDialog(null, "No has ingresado numero aun.");
				else {
					try {
						Lugar lugares[] = agencia.listarLugares();
						if(lugares != null && Integer.parseInt(textFieldEditar.getText()) < 1 
								&& Integer.parseInt(textFieldEditar.getText()) >= lugares.length)
							JOptionPane.showMessageDialog(null, "Numero fuera del rango.");
						else {
							// ir a edicion de lugar
						}
					}
					catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Solamente se permiten numeros.");
					}
				}
			}
		});
		btnEditar.setBounds(325, 183, 89, 23);
		panel.add(btnEditar);
		

		DefaultTableModel model = (DefaultTableModel) tableLugares.getModel();
		model.setNumRows(0);
		String lugares[] = agencia.listarLugarestoString();
		if(lugares != null)
			for(int i = 0; i < lugares.length; i++) {
				String[] row = { "" + (i + 1), lugares[i] };
				model.addRow(row);
			}
	}
}
