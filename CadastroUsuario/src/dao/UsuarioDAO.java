package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;
import bd.ConexaoDAO;

public class UsuarioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	List<UsuarioDTO> list = new ArrayList<>();

	public void insertUsuario(UsuarioDTO usuarioDto) {
		
		String sql = "insert into usuario (nome, tipo_logradouro, logradouro,"
				+ " numero, telefone_residencial, telefone_comercial,"
				+ " telefone_celular, cpf, rg) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuarioDto.getNome());
			pstm.setString(2, usuarioDto.getTipo_logradouro());
			pstm.setString(3, usuarioDto.getLogradouro());
			pstm.setInt(4, usuarioDto.getNumero());
			pstm.setString(5, usuarioDto.getTelefone_residencial());
			pstm.setString(6, usuarioDto.getTelefone_comercial());
			pstm.setString(7, usuarioDto.getTelefone_celular());
			pstm.setString(8, usuarioDto.getCpf());
			pstm.setString(9, usuarioDto.getRg());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO " + e);
		}
	}
	
	public List<UsuarioDTO> findAll() {
		String sql = "SELECT * FROM usuario";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				UsuarioDTO usuarioDto = new UsuarioDTO();
				usuarioDto.setId(rs.getInt("id"));
				usuarioDto.setNome(rs.getString("nome"));
				usuarioDto.setTipo_logradouro(rs.getString("tipo_logradouro"));
				usuarioDto.setLogradouro(rs.getString("logradouro"));
				usuarioDto.setNumero(rs.getInt("numero"));
				usuarioDto.setTelefone_residencial(rs.getString("telefone_residencial"));
				usuarioDto.setTelefone_comercial(rs.getString("telefone_comercial"));
				usuarioDto.setTelefone_celular(rs.getString("telefone_celular"));
				usuarioDto.setCpf(rs.getString("cpf"));
				usuarioDto.setRg(rs.getString("rg"));	
				
				list.add(usuarioDto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO findAll: " + e);
		}
		
		return list;
	}
	
	public UsuarioDTO findById(String cpf) {
		String sql = "SELECT * FROM usuario WHERE cpf = ?";
		conn = new ConexaoDAO().conectaBD();
		
		UsuarioDTO usuarioDto = new UsuarioDTO();
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cpf);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				usuarioDto.setId(rs.getInt("id"));
				usuarioDto.setNome(rs.getString("nome"));
				usuarioDto.setTipo_logradouro(rs.getString("tipo_logradouro"));
				usuarioDto.setLogradouro(rs.getString("logradouro"));
				usuarioDto.setNumero(rs.getInt("numero"));
				usuarioDto.setTelefone_residencial(rs.getString("telefone_residencial"));
				usuarioDto.setTelefone_comercial(rs.getString("telefone_comercial"));
				usuarioDto.setTelefone_celular(rs.getString("telefone_celular"));
				usuarioDto.setCpf(rs.getString("cpf"));
				usuarioDto.setRg(rs.getString("rg"));	
			}
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO findAll: " + e);
		}
		
		return usuarioDto;
	}
	
	public void updateUsuario(UsuarioDTO usuarioDto) {
		
		String sql = "UPDATE usuario SET "
					+ "	nome = ?,	"
					+ "	tipo_logradouro = ?,	"
					+ "	logradouro = ?,	"
					+ "	numero = ?,	"
					+ "	telefone_residencial = ?,	"
					+ "	telefone_comercial = ?,	"
					+ "	telefone_celular = ?,	"
					+ "	cpf = ?,	"
					+ "	rg = ?	"
					+ "	where id = ?	";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuarioDto.getNome());
			pstm.setString(2, usuarioDto.getTipo_logradouro());
			pstm.setString(3, usuarioDto.getLogradouro());
			pstm.setInt(4, usuarioDto.getNumero());
			pstm.setString(5, usuarioDto.getTelefone_residencial());
			pstm.setString(6, usuarioDto.getTelefone_comercial());
			pstm.setString(7, usuarioDto.getTelefone_celular());
			pstm.setString(8, usuarioDto.getCpf());
			pstm.setString(9, usuarioDto.getRg());
			pstm.setInt(10, usuarioDto.getId());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO update:" + e);
		}
	}
	
	public void deleteUsuario(UsuarioDTO usuarioDto) {
		String sql = "DELETE FROM usuario where id = ?";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, usuarioDto.getId());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO delete:" + e);
		}
	}
}