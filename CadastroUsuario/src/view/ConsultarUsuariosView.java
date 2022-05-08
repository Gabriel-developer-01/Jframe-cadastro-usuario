package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.UsuarioDTO;

public class ConsultarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tableUsuario;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarUsuariosView frame = new ConsultarUsuariosView();
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
	public ConsultarUsuariosView() {
		setTitle("Consulta usuarios\r\n");
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 391);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(169, 169, 169));
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableUsuario = new JTable();
		tableUsuario.setFont(new Font("SansSerif", Font.BOLD, 10));
		tableUsuario.setForeground(new Color(0, 0, 0));
		tableUsuario.setBackground(new Color(176, 196, 222));
		
		model = new DefaultTableModel();
		tableUsuario.setModel(model);
		
		model.addColumn("Nome");
		model.addColumn("Tipo logradouro");
		model.addColumn("Logradouro");
		model.addColumn("N\u00FAmero");
		model.addColumn("Telefone Residencial");
		model.addColumn("Telefone comercial");
		model.addColumn("Telefone celular");
		model.addColumn("CPF");
		model.addColumn("RG");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane.setViewportView(tableUsuario);
		contentPane.add(scrollPane);
	}
	
	public void carregarDados(List<UsuarioDTO> usuario) {
		for(UsuarioDTO usuarioDto: usuario) {
			Object[] fila = new Object[9];
			fila[0] = usuarioDto.getNome();
			fila[1] = usuarioDto.getTipo_logradouro();
			fila[2] = usuarioDto.getLogradouro();
			fila[3] = usuarioDto.getNumero();
			fila[4] = usuarioDto.getTelefone_residencial();
			fila[5] = usuarioDto.getTelefone_comercial();
			fila[6] = usuarioDto.getTelefone_celular();
			fila[7] = usuarioDto.getCpf();
			fila[8] = usuarioDto.getRg();
			
			model.addRow(fila);
		}
	}
}