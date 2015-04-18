import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameAgregarBus extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Tramo tramo = null;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarBus frame = new FrameAgregarBus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	public FrameAgregarBus(Agencia agencia) {
		setTitle("Agregar un Bus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(27, 94, 60, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHoraDeLlegada = new JLabel("Hora de llegada");
		lblHoraDeLlegada.setBounds(27, 144, 75, 14);
		contentPane.add(lblHoraDeLlegada);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de salida");
		lblHoraDeSalida.setBounds(27, 119, 93, 14);
		contentPane.add(lblHoraDeSalida);
		
		final JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.addItem("Dia");
		for (int i = 1; i <=31; i++) {
			comboBoxDia.addItem(String.valueOf(i));
		}
		comboBoxDia.setBounds(75, 91, 45, 20);
		contentPane.add(comboBoxDia);
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.addItem("Mes");
		for (int i = 1; i <= 12; i++) {
			comboBoxMes.addItem(String.valueOf(i));
		}
		comboBoxMes.setBounds(130, 91, 45, 20);
		contentPane.add(comboBoxMes);
		
		JComboBox<String> comboBoxAño = new JComboBox<String>();
		comboBoxAño.addItem("Año");
		for (int i = 1920; i <= 2015 ; i++) {
			comboBoxAño.addItem(String.valueOf(i));
		}
		comboBoxAño.setBounds(185, 91, 51, 20);
		contentPane.add(comboBoxAño);
		
		JLabel lblFechaActualY = new JLabel("Fecha actual y hora actual");
		lblFechaActualY.setBounds(27, 18, 176, 14);
		contentPane.add(lblFechaActualY);
		
		JComboBox<String> comboBoxHoraSal = new JComboBox<String>();
		comboBoxHoraSal.addItem("HSalida");
		for (int i = 00; i <= 23 ; i++) {
			comboBoxHoraSal.addItem(String.valueOf(i));
		}
		comboBoxHoraSal.setBounds(112, 116, 45, 20);
		contentPane.add(comboBoxHoraSal);
		
		JComboBox<String> comboBoxMinutoSal = new JComboBox<String>();
		comboBoxMinutoSal.addItem("MSalida");
		for (int i = 00; i <= 59 ; i++) {
			comboBoxMinutoSal.addItem(String.valueOf(i));
		}
		comboBoxMinutoSal.setBounds(167, 116, 45, 20);
		contentPane.add(comboBoxMinutoSal);
		
		JComboBox<String> comboBoxHoraLleg = new JComboBox<String>();
		comboBoxHoraLleg.addItem("HLlegada");
		for (int i = 00; i <= 23 ; i++) {
			comboBoxHoraLleg.addItem(String.valueOf(i));
		}
		comboBoxHoraLleg.setBounds(112, 141, 45, 20);
		contentPane.add(comboBoxHoraLleg);
		
		JComboBox<String> comboBoxMinutoLleg = new JComboBox<String>();
		comboBoxMinutoLleg.addItem("MinutoLleg");
		for (int i = 00; i <= 59 ; i++) {
			comboBoxMinutoLleg.addItem(String.valueOf(i));
		}
		comboBoxMinutoLleg.setBounds(167, 141, 45, 20);
		contentPane.add(comboBoxMinutoLleg);
		
		JComboBox<String> comboBoxLugarSal = new JComboBox<String>();	
		comboBoxLugarSal.setBounds(112, 53, 91, 20);
		contentPane.add(comboBoxLugarSal);
		
		JComboBox<String> comboBoxLugarLleg = new JComboBox<String>();
		comboBoxLugarLleg.setBounds(318, 53, 85, 20);
		contentPane.add(comboBoxLugarLleg);

		JButton btnAgregarElBus = new JButton("Agregar el bus");
		btnAgregarElBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(comboBoxDia.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Dia no puede estar en blanco.");
				else if(comboBoxMes.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Mes no puede estar en blanco.");
				else if(comboBoxAño.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Año no pueden ser iguales.");
				else if(comboBoxHoraSal.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Hora de salida no puede estar en blanco.");
				else if(comboBoxMinutoSal.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Minutos de la salida no puede estar en blanco.");
				else if(comboBoxHoraLleg.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Hora de llegada no puede estar en blanco.");
				else if(comboBoxMinutoLleg.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Minutos de la llegada no puede estar en blanco.");
				else if(comboBoxLugarSal.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de la salida no puede estar en blanco.");
				else if(comboBoxLugarLleg.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de llegada no puede estar en blanco.");
				String dia, mes, año;
				String hora, minuto, horaLleg, minutoLleg;
				dia=(String)comboBoxDia.getSelectedItem();
				mes=(String)comboBoxMes.getSelectedItem();
				año=(String)comboBoxAño.getSelectedItem();
				hora=(String)comboBoxHoraSal.getSelectedItem();
				minuto=(String)comboBoxMinutoSal.getSelectedItem();
				horaLleg=(String)comboBoxHoraLleg.getSelectedItem();
				minutoLleg=(String)comboBoxMinutoLleg.getSelectedItem();
				tramo.agregarBus(hora, minuto, horaLleg, minutoLleg, dia, mes, año);
			}
		});
		btnAgregarElBus.setBounds(53, 190, 122, 23);
		contentPane.add(btnAgregarElBus);
		
		JLabel lblLugarSalida = new JLabel("Lugar Salida");
		lblLugarSalida.setBounds(27, 53, 75, 20);
		contentPane.add(lblLugarSalida);
		
		JLabel lblLugarLlegada = new JLabel("Lugar Llegada");
		lblLugarLlegada.setBounds(223, 56, 85, 14);
		contentPane.add(lblLugarLlegada);
		
				
		JButton btnVolver = new JButton("Volver al Menu Principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameAgregarBus.this.dispose();
			}
		});
		btnVolver.setBounds(199, 190, 183, 23);
		contentPane.add(btnVolver);
	}
	
}
