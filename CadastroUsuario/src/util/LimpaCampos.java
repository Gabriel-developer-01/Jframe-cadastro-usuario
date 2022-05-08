package util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class LimpaCampos {

	@SuppressWarnings("rawtypes")
	public static void LimpaTela(Container container) {     
        //limpa os campos     
        for (int i=0; i < container.getComponentCount(); i++) {   
            //varre todos os componentes     
            Component c = container.getComponent(i);     
            if (c instanceof JTextField) {                           
                JTextField field = (JTextField) c;   
                field.setText("");                      
            }else if (c instanceof JComboBox) {
            	JComboBox field = (JComboBox) c;
            	field.setSelectedIndex(0);
            }   
        }   
    }    
}
