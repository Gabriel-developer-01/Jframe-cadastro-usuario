package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.UsuarioDTO;

public class ConsultarUsuariosView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tableUsuario;
	private DefaultTableModel model;
	private JButton btnVoltarMenuPrincipal;

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
		setBackground(new Color(245, 245, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 439);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(169, 169, 169));
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 740, 357);
		
		tableUsuario = new JTable();
		tableUsuario.setFont(new Font("SansSerif", Font.BOLD, 10));
		tableUsuario.setForeground(new Color(0, 0, 0));
		tableUsuario.setBackground(new Color(255, 255, 255));
		
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
		contentPane.setLayout(null);
		
		scrollPane.setViewportView(tableUsuario);
		contentPane.add(scrollPane);
		
		btnVoltarMenuPrincipal = new JButton("Voltar");
		btnVoltarMenuPrincipal.setIcon(new ImageIcon(ConsultarUsuariosView.class.getResource("/icones/back-icon.png")));
		btnVoltarMenuPrincipal.addActionListener(this);
		btnVoltarMenuPrincipal.setBounds(275, 372, 194, 30);
		contentPane.add(btnVoltarMenuPrincipal);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVoltarMenuPrincipal) {
			handle_btnVoltarMenuPrincipal_actionPerformed(e);
		}
	}
	
	protected void handle_btnVoltarMenuPrincipal_actionPerformed(ActionEvent e) {
		dispose();
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