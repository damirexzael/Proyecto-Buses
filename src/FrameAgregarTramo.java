import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameAgregarTramo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarTramo frame = new FrameAgregarTramo();
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
	public FrameAgregarTramo(final Agencia agencia) {
		setTitle("Agregar un Tramo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLugarDeLlegada = new JLabel("Lugar de Llegada");
		lblLugarDeLlegada.setBounds(47, 31, 114, 14);
		contentPane.add(lblLugarDeLlegada);
		
		JLabel lblLugarDeSalida = new JLabel("Lugar de Salida");
		lblLugarDeSalida.setBounds(47, 94, 114, 14);
		contentPane.add(lblLugarDeSalida);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(250, 31, 71, 14);
		contentPane.add(lblTarifa);
		
		JComboBox<String> comboBoxLlegada = new JComboBox<String>();
		comboBoxLlegada.setBounds(163, 28, 71, 20);
		contentPane.add(comboBoxLlegada);
		
		JComboBox<String> comboBoxSalida = new JComboBox<String>();
		comboBoxSalida.setBounds(163, 91, 71, 20);
		contentPane.add(comboBoxSalida);
		
		textField = new JTextField();
		textField.setBounds(304, 28, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAgregarTramo = new JButton("Agregar Tramo");
		btnAgregarTramo.setBounds(65, 190, 139, 23);
		contentPane.add(btnAgregarTramo);
		
		JButton btnVolver = new JButton("Volver al Menu Principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameAgregarTramo.this.dispose();
			}
		});
		btnVolver.setBounds(215, 190, 189, 23);
		contentPane.add(btnVolver);
	}
}
