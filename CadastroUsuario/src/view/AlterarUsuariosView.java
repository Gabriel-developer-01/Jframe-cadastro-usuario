package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import DTO.UsuarioDTO;
import dao.UsuarioDAO;
import util.LimpaCampos;
import javax.swing.ImageIcon;

public class AlterarUsuariosView extends JFrame implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable tableAlterar;
	private DefaultTableModel model;
	private JTextField textNome;
	private JTextField textLogradouro;
	private JTextField textNumero;
	private JFormattedTextField formattedTextTelefoneComercial;
	private JFormattedTextField formattedTextTelefoneResidencial;
	private JFormattedTextField formattedTextTelefoneCelular;
	private JFormattedTextField formattedTextCpf;
	private JFormattedTextField formattedTextRg;
	private final String ruas[] = { "Rua", "Avenida", "Estrada" };
	private JButton btnAlterar;
	private JComboBox<?> cbTipoLogra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarUsuariosView frame = new AlterarUsuariosView();
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
	public AlterarUsuariosView() {
		setTitle("Alterar usuarios\r\n");
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 562);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 280, 936, 240);

		tableAlterar = new JTable();
		tableAlterar.addMouseListener(this);
		tableAlterar.setFont(new Font("SansSerif", Font.BOLD, 10));
		tableAlterar.setForeground(new Color(0, 0, 0));
		tableAlterar.setBackground(new Color(192, 192, 192));

		model = new DefaultTableModel();
		tableAlterar.setModel(model);

		model.addColumn("Nome");
		model.addColumn("Tipo logradouro");
		model.addColumn("Logradouro");
		model.addColumn("N\u00FAmero");
		model.addColumn("Telefone Residencial");
		model.addColumn("Telefone comercial");
		model.addColumn("Telefone celular");
		model.addColumn("CPF");
		model.addColumn("RG");

		scrollPane.setViewportView(tableAlterar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 18, 32, 13);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 10));


		JLabel lblTipoDeLogradouro = new JLabel("Tipo de Logradouro:");
		lblTipoDeLogradouro.setBounds(15, 47, 104, 13);
		lblTipoDeLogradouro.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(15, 72, 64, 13);
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(15, 97, 43, 13);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblTelefoneResidencial = new JLabel("Telefone Residencial:");
		lblTelefoneResidencial.setBounds(15, 122, 109, 13);
		lblTelefoneResidencial.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblTelefoneComercial = new JLabel("Telefone Comercial:");
		lblTelefoneComercial.setBounds(15, 147, 101, 13);
		lblTelefoneComercial.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblTelefoneCelular = new JLabel("Telefone Celular:");
		lblTelefoneCelular.setBounds(15, 172, 86, 13);
		lblTelefoneCelular.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(15, 197, 22, 13);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(15, 219, 18, 13);
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 10));

		textNome = new JTextField();
		textNome.setBounds(51, 15, 564, 19);
		textNome.setColumns(10);

		textLogradouro = new JTextField();
		textLogradouro.setBounds(83, 69, 532, 19);
		textLogradouro.setColumns(10);

		textNumero = new JTextField();
		textNumero.setBounds(62, 94, 47, 19);
		textNumero.setColumns(10);

		formataCampos();
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(AlterarUsuariosView.class.getResource("/icones/Gear-icon.png")));
		btnAlterar.setBounds(421, 249, 194, 21);
		btnAlterar.addActionListener(this);
		
		cbTipoLogra = new JComboBox<Object>(ruas);
		cbTipoLogra.setBounds(123, 44, 492, 19);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(lblNumero);
		contentPane.add(textNumero);
		contentPane.add(lblTelefoneResidencial);
		contentPane.add(formattedTextTelefoneResidencial);
		contentPane.add(lblTelefoneComercial);
		contentPane.add(formattedTextTelefoneComercial);
		contentPane.add(lblTelefoneCelular);
		contentPane.add(formattedTextTelefoneCelular);
		contentPane.add(lblCpf);
		contentPane.add(formattedTextCpf);
		contentPane.add(lblRg);
		contentPane.add(formattedTextRg);
		contentPane.add(lblTipoDeLogradouro);
		contentPane.add(cbTipoLogra);
		contentPane.add(lblNome);
		contentPane.add(textNome);
		contentPane.add(btnAlterar);
		contentPane.add(lblLogradouro);
		contentPane.add(textLogradouro);
	}

	public void carregarDados(List<UsuarioDTO> usuario) {

		for (UsuarioDTO usuarioDto : usuario) {
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
		if (e.getSource() == tableAlterar) {
			handle_tableAlterar_mouseClicked(e);
		}
	}

	protected void handle_tableAlterar_mouseClicked(MouseEvent e) {
		int posicao = tableAlterar.getSelectedRow();
		String cpfUsuario = (String) tableAlterar.getValueAt(posicao, 7);

		UsuarioDAO usuarioDao = new UsuarioDAO();
		UsuarioDTO usuario = usuarioDao.findById(cpfUsuario);
		
		textNome.setText(usuario.getNome());
		textLogradouro.setText(usuario.getLogradouro());
		textNumero.setText(usuario.getNumero().toString());
		formattedTextTelefoneResidencial.setText(usuario.getTelefone_residencial());
		formattedTextTelefoneComercial.setText(usuario.getTelefone_comercial());
		formattedTextTelefoneCelular.setText(usuario.getTelefone_celular());
		formattedTextCpf.setText(usuario.getCpf());
		formattedTextRg.setText(usuario.getRg());

	}

	private void formataCampos() {
		try {
			formattedTextTelefoneResidencial = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			formattedTextTelefoneResidencial.setBounds(128, 119, 180, 19);
			formattedTextTelefoneComercial = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
			formattedTextTelefoneComercial.setBounds(120, 144, 180, 19);
			formattedTextTelefoneCelular = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
			formattedTextTelefoneCelular.setBounds(105, 169, 180, 19);
			formattedTextCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			formattedTextCpf.setBounds(41, 194, 180, 19);
			formattedTextRg = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
			formattedTextRg.setBounds(37, 219, 180, 19);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAlterar) {
			handle_btnAlterar_actionPerformed(e);
		}
	}
	
	protected void handle_btnAlterar_actionPerformed(ActionEvent e) {
		if(validarCampos()) {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			int posicao = tableAlterar.getSelectedRow();
			String cpfUsuario = (String) tableAlterar.getValueAt(posicao, 7);

			UsuarioDTO usuario = usuarioDao.findById(cpfUsuario);
			UsuarioDTO usuarioSalvar = prepararUsuario();
			usuarioSalvar.setId(usuario.getId());

			usuarioDao.updateUsuario(usuarioSalvar);
			int confirm = JOptionPane.showConfirmDialog(null, "Deseja confirmar as alterações?");
			if(confirm == JOptionPane.YES_OPTION) {
				LimpaCampos.LimpaTela(getContentPane());
				atualizarGrid();
			}
		}
	}
	
	private void atualizarGrid() {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<UsuarioDTO> listUsuario = usuarioDao.findAll();
		
		//limpa os dados da grid para carregar os novos dados com as alterações
		((DefaultTableModel) tableAlterar.getModel()).setRowCount(0);
		
		carregarDados(listUsuario);
	}
	
	private UsuarioDTO prepararUsuario() {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNome(textNome.getText());
		usuario.setTipo_logradouro(cbTipoLogra.getSelectedItem().toString());
		usuario.setLogradouro(textLogradouro.getText());
		usuario.setNumero(Integer.parseInt(textNumero.getText()));
		usuario.setTelefone_residencial(formattedTextTelefoneResidencial.getText());
		usuario.setTelefone_comercial(formattedTextTelefoneComercial.getText());
		usuario.setTelefone_celular(formattedTextTelefoneCelular.getText());
		usuario.setCpf(formattedTextCpf.getText());
		usuario.setRg(formattedTextRg.getText());
		return usuario;
	}
	
	private boolean validarCampos() {
		String nome = textNome.getText();
		// nos campos formatados foi utilizados um regex para tirar pontuações e traços dos campos formatados.
		String cpf = formattedTextCpf.getText().replaceAll("\\D", "");
		String rg = formattedTextRg.getText().replaceAll("\\D", "");
		Integer celular = formattedTextTelefoneCelular.getText().replaceAll("\\D", "").length();
		if(nome.isEmpty() || cpf.isEmpty() || rg.isEmpty() || celular.equals(1)) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios: Nome, CPF, RG e telefone celular");
		}else {
			return true;
		}
		
		return false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}