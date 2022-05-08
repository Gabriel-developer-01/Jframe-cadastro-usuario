package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.UsuarioDTO;
import dao.UsuarioDAO;
import util.LimpaCampos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ExcluirUsuariosView extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tableExcluir;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirUsuariosView frame = new ExcluirUsuariosView();
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
	public ExcluirUsuariosView() {
		setTitle("Excluir usuarios\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableExcluir = new JTable();
		tableExcluir.addMouseListener(this);
		tableExcluir.setFont(new Font("SansSerif", Font.BOLD, 10));
		
		model = new DefaultTableModel();
		tableExcluir.setModel(model);
		
		model.addColumn("Nome");
		model.addColumn("Tipo logradouro");
		model.addColumn("Logradouro");
		model.addColumn("N\u00FAmero");
		model.addColumn("Telefone Residencial");
		model.addColumn("Telefone comercial");
		model.addColumn("Telefone celular");
		model.addColumn("CPF");
		model.addColumn("RG");
		
		scrollPane.setViewportView(tableExcluir);
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
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableExcluir) {
			handle_tableExcluir_mouseClicked(e);
		}
	}
	
	protected void handle_tableExcluir_mouseClicked(MouseEvent e) {
		int posicao = tableExcluir.getSelectedRow();
		String cpfUsuario = (String) tableExcluir.getValueAt(posicao, 7);

		UsuarioDAO usuarioDao = new UsuarioDAO();
		UsuarioDTO usuario = usuarioDao.findById(cpfUsuario);
		
		usuarioDao.deleteUsuario(usuario);
		int confirm = JOptionPane.showConfirmDialog(null, "Deseja confirmar a exclusão?");
		if(confirm == JOptionPane.YES_OPTION) {
			LimpaCampos.LimpaTela(getContentPane());
			atualizarGrid();
		}
	}
	
	private void atualizarGrid() {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<UsuarioDTO> listUsuario = usuarioDao.findAll();
		
		//limpa os dados da grid para carregar os novos dados com as alterações
		((DefaultTableModel) tableExcluir.getModel()).setRowCount(0);
		
		carregarDados(listUsuario);
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}