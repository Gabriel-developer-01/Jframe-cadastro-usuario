package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {

	public Connection conectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/faculdade?user=root&password=[aqui a senha]";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ConexaoDAO " + e.getMessage());
		}
		return conn;
	}
}
