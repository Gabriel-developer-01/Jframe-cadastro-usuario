package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DTO.UsuarioDTO;
import dao.UsuarioDAO;
import util.LimpaCampos;

public class UsuarioView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textLogradouro;
	private JTextField textNumero;
	private final String ruas[] = {"Rua", "Avenida", "Estrada"};
	private JFormattedTextField formattedTextTelefoneComercial;
	private JFormattedTextField formattedTextTelefoneResidencial;
	private JFormattedTextField formattedTextTelefoneCelular;
	private JFormattedTextField formattedTextCpf;
	private JFormattedTextField formattedTextRg;
	private JComboBox<?> cbTipoLog;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnBuscar;
	private ConsultarUsuariosView jframeConsultar;
	private AlterarUsuariosView jframeAlterar;
	private ExcluirUsuariosView jframeExcluir;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioView frame = new UsuarioView();
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
	public UsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblTipoDeLogradouro = new JLabel("Tipo de Logradouro:");
		lblTipoDeLogradouro.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblTelefoneResidencial = new JLabel("Telefone Residencial:");
		lblTelefoneResidencial.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblTelefoneComercial = new JLabel("Telefone Comercial:");
		lblTelefoneComercial.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblTelefoneCelular = new JLabel("Telefone Celular:");
		lblTelefoneCelular.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textLogradouro = new JTextField();
		textLogradouro.setColumns(10);
		
		cbTipoLog = new JComboBox<Object>(ruas);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		
		formataCampos();
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(this);
		btnNovo.setIcon(new ImageIcon(UsuarioView.class.getResource("/icones/add-icon.png")));
		
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(this);
		btnAlterar.setIcon(new ImageIcon(UsuarioView.class.getResource("/icones/Gear-icon.png")));
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		btnExcluir.setIcon(new ImageIcon(UsuarioView.class.getResource("/icones/Close-2-icon.png")));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(UsuarioView.class.getResource("/icones/Search-icon.png")));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNumero)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpf)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(formattedTextCpf, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRg)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(formattedTextRg, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTelefoneCelular)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(formattedTextTelefoneCelular, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addGap(6)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblTelefoneResidencial)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(formattedTextTelefoneResidencial, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(lblTelefoneComercial)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(formattedTextTelefoneComercial, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
									.addGap(20)
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
							.addGap(211))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblLogradouro)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textLogradouro))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblTipoDeLogradouro)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cbTipoLog, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblNome)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeLogradouro)
						.addComponent(cbTipoLog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogradouro)
						.addComponent(textLogradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(formattedTextTelefoneResidencial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefoneResidencial))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefoneComercial)
						.addComponent(formattedTextTelefoneComercial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefoneCelular)
						.addComponent(formattedTextTelefoneCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(formattedTextCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRg)
						.addComponent(formattedTextRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			handle_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnExcluir) {
			handle_btnExcluir_actionPerformed(e);
		}
		if (e.getSource() == btnAlterar) {
			handle_btnAlterar_actionPerformed(e);
		}
		if (e.getSource() == btnNovo) {
			handle_btnNovo_actionPerformed(e);
		}
	}
	
	protected void handle_btnNovo_actionPerformed(ActionEvent e) {
		
		if(validarCampos()) {
			UsuarioDTO usuario = prepararUsuario();
			
			UsuarioDAO usuarioDao = new UsuarioDAO();
			usuarioDao.insertUsuario(usuario);
			
			int confirm = JOptionPane.showConfirmDialog(null, "Deseja cadastrar usuario?");
			if(confirm == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
				LimpaCampos.LimpaTela(getContentPane());
			}
		}
	}

	protected void handle_btnAlterar_actionPerformed(ActionEvent e) {
		jframeAlterar = new AlterarUsuariosView();
		jframeAlterar.setVisible(true);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<UsuarioDTO> listUsuario = usuarioDao.findAll();
		
		jframeAlterar.carregarDados(listUsuario);
	}
	
	protected void handle_btnExcluir_actionPerformed(ActionEvent e) {
		jframeExcluir = new ExcluirUsuariosView();
		jframeExcluir.setVisible(true);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<UsuarioDTO> listUsuario = usuarioDao.findAll();
		
		jframeExcluir.carregarDados(listUsuario);
	}
	
	protected void handle_btnBuscar_actionPerformed(ActionEvent e) {

		jframeConsultar = new ConsultarUsuariosView();
		jframeConsultar.setVisible(true);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<UsuarioDTO> listUsuario = usuarioDao.findAll();
		
		jframeConsultar.carregarDados(listUsuario);
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
	
	private void formataCampos() {
		try {
			formattedTextTelefoneResidencial = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			formattedTextTelefoneComercial = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
			formattedTextTelefoneCelular = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
			formattedTextCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			formattedTextRg = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private UsuarioDTO prepararUsuario() {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNome(textNome.getText());
		usuario.setTipo_logradouro(cbTipoLog.getSelectedItem().toString());
		usuario.setLogradouro(textLogradouro.getText());
		usuario.setNumero(Integer.parseInt(textNumero.getText()));
		usuario.setTelefone_residencial(formattedTextTelefoneResidencial.getText());
		usuario.setTelefone_comercial(formattedTextTelefoneComercial.getText());
		usuario.setTelefone_celular(formattedTextTelefoneCelular.getText());
		usuario.setCpf(formattedTextCpf.getText());
		usuario.setRg(formattedTextRg.getText());
		return usuario;
	}
}