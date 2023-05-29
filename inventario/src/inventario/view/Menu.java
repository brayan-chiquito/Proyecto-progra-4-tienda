package inventario.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Menu extends JFrame implements ActionListener {

    private JButton btnOpcion1, btnOpcion2, btnOpcion3, btnSalir;
    private JPanel panel;

    public Menu() {
        setTitle("Menú");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel y asignar layout
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Crear botones
        btnOpcion1 = crearBoton("Producto");
        btnOpcion2 = crearBoton("Pedidos");
        btnOpcion3 = crearBoton("Movimientos");
        btnSalir = crearBoton("Salir");

        // Agregar botones al panel
        panel.add(btnOpcion1);
        panel.add(btnOpcion2);
        panel.add(btnOpcion3);
        panel.add(btnSalir);

        // Agregar listener a los botones
        btnOpcion1.addActionListener(this);
        btnOpcion2.addActionListener(this);
        btnOpcion3.addActionListener(this);
        btnSalir.addActionListener(this);

        // Agregar panel al frame
        add(panel);

        setVisible(true);
        setLocationRelativeTo(null);
        
    }

    public JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(150, 40));
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(59, 89, 182));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    public void actionPerformed(ActionEvent e) {
        // Obtener el botón que se ha presionado
        JButton botonPresionado = (JButton) e.getSource();

        // Verificar el botón y hacer lo correspondiente
        if (botonPresionado == btnOpcion1) {
        	ControlDeProductos controlDeVuelos = new ControlDeProductos();
        } else if (botonPresionado == btnOpcion2) {
            
        }else if (botonPresionado == btnOpcion3) {
            
        }else if (botonPresionado == btnSalir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}