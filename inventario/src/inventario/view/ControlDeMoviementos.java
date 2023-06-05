package inventario.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import inventario.controller.MovimientoController;
import inventario.controller.ProductoController;
import inventario.modelo.Movimiento;
import inventario.modelo.Producto;

public class ControlDeMoviementos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel labelTipo, labelProducto, labelCantidad;
    ;
    private JTextField textoCantidad;
    ;
    private JComboBox<Object> comboTipo;
    private JComboBox<Producto> comboProducto;
    private JButton botonGuardar, botonModificar, botonLimpiar, botonEliminar, botonReporte;
    private JTable tabla;
    private DefaultTableModel modelo;
    private ProductoController productoController;
    private MovimientoController movimientoController;
    public ControlDeMoviementos() {
        super("Movimientos");
        //falta
        this.productoController = new ProductoController();
        this.movimientoController = new MovimientoController();

        Container container = getContentPane();
        setLayout(null);

        configurarCamposDelFormulario(container);

        configurarTablaDeContenido(container);

        configurarAccionesDelFormulario();
    }

    private void configurarTablaDeContenido(Container container) {
    	tabla = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return row != 0; // La fila de cabecera no es editable
            }
        };
        //falta
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("id");
        modelo.addColumn("tipo");
        modelo.addColumn("producto id");
        modelo.addColumn("cantidad");
        modelo.addColumn("fecha");

        cargarTabla();

        tabla.setBounds(10, 205, 760, 280);

        botonEliminar = new JButton("Eliminar");
        botonModificar = new JButton("Modificar");
        botonReporte = new JButton("Ver Reporte");
        botonEliminar.setBounds(10, 500, 80, 20);
        botonModificar.setBounds(100, 500, 80, 20);
        botonReporte.setBounds(190, 500, 80, 20);

        container.add(tabla);
        container.add(botonEliminar);
        container.add(botonModificar);
        container.add(botonReporte);

        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void configurarCamposDelFormulario(Container container) {
        labelTipo = new JLabel("Tipo");
        labelProducto = new JLabel("Producto id");
        labelCantidad = new JLabel("Cantidad");

        labelTipo.setBounds(10, 10, 240, 15);
        labelProducto.setBounds(10, 50, 240, 15);
        labelCantidad.setBounds(10, 90, 240, 15);

        labelTipo.setForeground(Color.BLACK);
        labelProducto.setForeground(Color.BLACK);
        labelCantidad.setForeground(Color.BLACK);
        
        textoCantidad = new JTextField();
        comboTipo = new JComboBox<>();
        comboTipo.addItem("Elige un Tipo");
        comboTipo.addItem("Entrada");
        comboTipo.addItem("Salida");
        comboProducto = new JComboBox<>();
        comboProducto.addItem(new Producto(0,"elije producto"));
        
        var productos = this.productoController.listar();
        productos.forEach(producto -> comboProducto.addItem(producto));


        comboTipo.setBounds(10, 25, 265, 20);
        comboProducto.setBounds(10, 65, 265, 20);
        textoCantidad.setBounds(10, 105, 265, 20);

        botonGuardar = new JButton("Guardar");
        botonLimpiar = new JButton("Limpiar");
        botonGuardar.setBounds(10, 175, 80, 20);
        botonLimpiar.setBounds(100, 175, 80, 20);

        container.add(labelTipo);
        container.add(labelProducto);
        container.add(labelCantidad);
        container.add(textoCantidad);
        container.add(comboTipo);
        container.add(comboProducto);
        container.add(botonGuardar);
        container.add(botonLimpiar);
    }
    //falta 
    private void configurarAccionesDelFormulario() {
        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirReporte();
            }
        });
    }

    private void abrirReporte() {
        //new ReporteFrameVuelos(this);
    }

    private void limpiarTabla() {
        modelo.getDataVector().clear();
    }

    private boolean tieneFilaElegida() {
        return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }

    private void modificar() {
    	JOptionPane.showMessageDialog(this, "No se puede modificar");
//    	if (tieneFilaElegida() || tabla.getSelectedRow() == 0) {
//            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
//            return;
//        }
//
//        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
//                .ifPresentOrElse(fila -> {
//                	Integer id = (Integer) modelo.getValueAt(tabla.getSelectedRow(), 0);
//                	Integer idProducto = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());
//                    Integer cantidad = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
//                    
//                    int productoModificado;
//					productoModificado = this.movimientoController.modificar(cantidad, id);
//					
//					JOptionPane.showMessageDialog(this, "Item " + productoModificado + " actualizado con éxito!");
//                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

    private void eliminar() {
    	if (tieneFilaElegida() || tabla.getSelectedRow() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = (Integer) modelo.getValueAt(tabla.getSelectedRow(), 0);
                    String tipo = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
                    Integer idProducto = (Integer) modelo.getValueAt(tabla.getSelectedRow(), 2);
                    Integer cantidad = (Integer) modelo.getValueAt(tabla.getSelectedRow(), 3);
                    
                    int item;
                    item = this.movimientoController.eliminar(id, idProducto, cantidad, tipo);
                    
                    if(item == 0) {
                    	JOptionPane.showMessageDialog(this, "No se puede realizar la eliminacion, cantidad supera el stock");
                    	return;
                    }

                    modelo.removeRow(tabla.getSelectedRow());

                    JOptionPane.showMessageDialog(this, "Item " + item + " eliminado con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

    private void cargarTabla() {
    	
    	modelo.addRow(new Object[] {
    			"id",
    	        "tipo",
    	        "producto id",
    	        "cantidad",
    	        "fecha"
    	    });
    	
    	var movimientos = this.movimientoController.listar();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        movimientos.forEach(movimiento -> {
            LocalDateTime fecha = movimiento.getFecha();
            String fechaFormateada = fecha.format(formatter);

            modelo.addRow(new Object[] {
                movimiento.getId(),
                movimiento.getTipoString(),
                movimiento.getProducto_id(),
                movimiento.getCantidad(),
                fechaFormateada
            });
        });
    }

    private void guardar() {
        

        var producto = (Producto) comboProducto.getSelectedItem();
        var tipo = (Object)comboTipo.getSelectedItem();
        
        if (tipo == "Elige un Tipo") {
            JOptionPane.showMessageDialog(this, "Por favor elije un tipo");
            return;
        }
        if (producto.getId() == 0) {
        	JOptionPane.showMessageDialog(this, "Por favor elije un producto");
        	return;
        }
    
        
        Integer cantidad;
        try {
            cantidad = Integer.parseInt(textoCantidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, String
                    .format("El campo cantidad debe ser numérico dentro del rango %d y %d.", 0, Integer.MAX_VALUE));
            return;
        }

        // TODO
        var movimiento = new Movimiento(cantidad);
        boolean guardado = this.movimientoController.guardar(tipo.toString(),producto.getId(),movimiento);
        
        if(guardado == true) {
        	JOptionPane.showMessageDialog(this, "Registrado con éxito!");
        }else {
        	JOptionPane.showMessageDialog(this, "Cantidad de salida supera existencias!");
		}
        

        this.limpiarFormulario();
    }

    private void limpiarFormulario() {
        this.textoCantidad.setText("");
        this.comboTipo.setSelectedIndex(0);
        this.comboProducto.setSelectedIndex(0);
    }

}
