/**
 * @author Daniel
**/

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class Lista {
    private ArrayList<Productos> list;
    
    public Lista(ArrayList<Productos> list) {
        this.list = list;
    }
    
    public ArrayList<Productos> Actualizar() {
        return this.list;
    }
    
    public void Agregar(Productos p) {
        this.list.add(p);
    }
    
    public Productos Buscar(String codigo) {
        for (Productos x : this.list) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }    
        return null;
    }
    
    public int Remover(String codigo) {
        Iterator<Productos> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            Productos x = iterator.next();
            if (codigo.equals(x.getCodigo())) {
                iterator.remove();
                return 0; // Éxito
            }
        }
        return 1; // No se encontró el producto
    }
}

class Productos {
    private String codigo;
    private String descripcion;
    private Double cantidad;
    private Double precio;
    
    public String getCodigo() {
        return codigo;
    }
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}

public class ListaNodos extends JFrame implements ActionListener {
	private JLabel etiqueta;
	private JButton botonSalvar;
	private JButton botonBuscar;
	private JButton botonRemover;
	private JButton botonNuevo;
	private JButton botonEditar;
	private JTextField codigoBuscar;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField precio;
	private JTextField cantidad;
	private JTextField total;
	
	private ArrayList<Productos> listaP = new ArrayList<Productos>(); 
	private Productos producto = new Productos();
	private Lista lista = new Lista(listaP);
	
	public ListaNodos(){
		this.setBounds(100, 100, 500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		etiqueta = new JLabel();
						//  X,  Y ,Width,Height
		etiqueta.setBounds(200, 10, 300, 30);
		etiqueta.setName("etiquetaTitulo");
		etiqueta.setText("Lista de Productos");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(10, 50, 300, 30);
		etiqueta.setName("etiquetaCodigo");
		etiqueta.setText("Ingrese Codigo:");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		codigoBuscar = new JTextField();
		codigoBuscar.setBounds(110, 50, 250, 30);
		codigoBuscar.setName("codigoBuscar");
		codigoBuscar.setText("");
		codigoBuscar.setVisible(true);
		this.add(codigoBuscar);
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(370, 50, 90,30);
		botonBuscar.setName("botonBuscar");
		botonBuscar.setText("Buscar");
		botonBuscar.setVisible(true);
		botonBuscar.addActionListener(this);
		this.add(botonBuscar);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(10, 150, 300, 30);
		etiqueta.setName("etiquetaCodigoResultado");
		etiqueta.setText("Codigo:");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		codigo = new JTextField();
		codigo.setBounds(90, 150, 200, 30);
		codigo.setName("codigo");
		codigo.setText("");
		codigo.setVisible(true);
		this.add(codigo);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(10, 200, 300, 30);
		etiqueta.setName("etiquetaDescripcion");
		etiqueta.setText("Descripción:");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		descripcion = new JTextField();
		descripcion.setBounds(90, 200, 350, 30);
		descripcion.setName("campoDescripcion");
		descripcion.setText("");
		descripcion.setVisible(true);
		this.add(descripcion);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(10, 250, 300, 30);
		etiqueta.setName("etiquetaPrecio");
		etiqueta.setText("Precio:");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		precio = new JTextField();
		precio.setBounds(90, 250, 200, 30);
		precio.setName("campoPrecio");
		precio.setText("");
		precio.setVisible(true);
		this.add(precio);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(10, 300, 300, 30);
		etiqueta.setName("etiquetaCantidad");
		etiqueta.setText("Cantidad:");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		cantidad = new JTextField();
		cantidad.setBounds(90, 300, 200, 30);
		cantidad.setName("cantidad");
		cantidad.setText("");
		cantidad.setVisible(true);
		this.add(cantidad);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(10, 350, 300, 30);
		etiqueta.setName("etiquetaTotal");
		etiqueta.setText("Total:");
		etiqueta.setVisible(true);
		this.add(etiqueta);
		
		total = new JTextField();
		total.setBounds(90, 350, 200, 30);
		total.setName("total");
		total.setText("");
		total.setVisible(true);
		this.add(total);
		
		botonNuevo = new JButton();
		botonNuevo.setBounds(50, 400, 90, 30);
		botonNuevo.setName("botonNuevo");
		botonNuevo.setText("Nuevo");
		botonNuevo.setVisible(true);
		botonNuevo.addActionListener(this);
		this.add(botonNuevo);
		
		botonRemover = new JButton();
		botonRemover.setBounds(150, 400, 90, 30);
		botonRemover.setName("botonRemover");
		botonRemover.setText("Remover");
		botonRemover.setVisible(true);
		botonRemover.addActionListener(this);
		this.add(botonRemover);
		
		botonSalvar = new JButton();
		botonSalvar.setBounds(250, 400, 90, 30);
		botonSalvar.setName("botonSalvar");
		botonSalvar.setText("Salvar");
		botonSalvar.setVisible(true);
		botonSalvar.addActionListener(this);
		this.add(botonSalvar);
		
		botonEditar = new JButton();
		botonEditar.setBounds(350, 400, 90, 30);
		botonEditar.setName("botonEditar");
		botonEditar.setText("Editar");
		botonEditar.setVisible(true);
		botonEditar.addActionListener(this);
		this.add(botonEditar);
		
		botonEditar.setEnabled(false);
		botonSalvar.setEnabled(false);
		botonRemover.setEnabled(false);
		
		total.setEnabled(false);
		codigo.setEnabled(false);
		descripcion.setEnabled(false);
		precio.setEnabled(false);
		cantidad.setEnabled(false);
	}
	
    public static void main(String args[]) {
		ListaNodos objeto = new ListaNodos();
		objeto.setVisible(true);
    }
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonBuscar) {
            botonEditar.setEnabled(true);
            botonSalvar.setEnabled(false);
            botonRemover.setEnabled(true);
            
            codigo.setEnabled(false);
            descripcion.setEnabled(false);
            precio.setEnabled(false);
            cantidad.setEnabled(false);
            
            Productos p = lista.Buscar(codigoBuscar.getText());
            if (p != null) {
                codigo.setText(p.getCodigo());
                descripcion.setText(p.getDescripcion());
                precio.setText(String.valueOf(p.getPrecio()));
                cantidad.setText(String.valueOf(p.getCantidad()));
                total.setText(String.valueOf(p.getCantidad() * p.getPrecio()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
            }
        } else if (e.getSource() == botonNuevo) {
            botonSalvar.setEnabled(true);
            botonRemover.setEnabled(false);
            botonEditar.setEnabled(false);
            
            codigo.setEnabled(true);
            descripcion.setEnabled(true);
            precio.setEnabled(true);
            cantidad.setEnabled(true);
            
            codigo.setText("");
            descripcion.setText("");
            precio.setText("");
            cantidad.setText("");
            total.setText("");
        } else if (e.getSource() == botonEditar) {
            botonSalvar.setEnabled(true);
            botonNuevo.setEnabled(false);
            botonRemover.setEnabled(false);
            
            codigo.setEnabled(true);
            descripcion.setEnabled(true);
            precio.setEnabled(true);
            cantidad.setEnabled(true);
        } else if (e.getSource() == botonRemover) {
            if (lista.Remover(codigoBuscar.getText()) == 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                codigo.setText("");
                descripcion.setText("");
                precio.setText("");
                cantidad.setText("");
                total.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró");
            }
        } else if (e.getSource() == botonSalvar) {
            Productos p = lista.Buscar(codigo.getText());
            if (p != null) { // Si el producto ya existe, estamos editando
                p.setDescripcion(descripcion.getText());
                p.setPrecio(Double.parseDouble(precio.getText()));
                p.setCantidad(Double.parseDouble(cantidad.getText()));
                total.setText(String.valueOf(p.getCantidad() * p.getPrecio()));
                JOptionPane.showMessageDialog(this, "Producto actualizado");
            } else { // Caso en que estamos creando un nuevo producto
                Productos nuevoProducto = new Productos();
                nuevoProducto.setCodigo(codigo.getText());
                nuevoProducto.setDescripcion(descripcion.getText());
                nuevoProducto.setPrecio(Double.parseDouble(precio.getText()));
                nuevoProducto.setCantidad(Double.parseDouble(cantidad.getText()));
                lista.Agregar(nuevoProducto);
                JOptionPane.showMessageDialog(this, "Producto registrado");
            }
            
            // Limpia los campos
            codigo.setText("");
            descripcion.setText("");
            precio.setText("");
            cantidad.setText("");
            total.setText("");
            
            // Restablece los botones
            botonNuevo.setEnabled(true);
            botonEditar.setEnabled(false);
            botonSalvar.setEnabled(false);
            botonRemover.setEnabled(false);
        }
    }
}
