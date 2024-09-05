/**
 *
 * @author Daniel
 */

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class Lista {
    
	private ArrayList<Productos> list = new ArrayList<>();
    private int index,posicion;
	
    public Lista(ArrayList<Productos> list){
        this.list=list;
    }
    public ArrayList<Productos> Actualizar(){
		return this.list;
	}
	public void Agregar(Productos p){
		this.list.add(p);
	}
	public Productos Buscar(String codigo){
		Productos ob=new Productos();
		this.index=0;
		for(Productos x: this.list){
			if(codigo.equals(x.getCodigo()))
			{
				ob.setCodigo(x.getCodigo());
				ob.setDescripcion(x.getDescripcion());
				ob.setPrecio(x.getPrecio());
				ob.setCantidad(x.getCantidad());
				this.posicion=this.index;
			}
			this.index++;
		}
		return ob;
	}
	public int getPosicion(){
		return this.posicion;
	}
	public void Remover(int index){
		this.list.remove(index);
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

    /**
     * @param args the command line arguments
     */
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
	
	public ListaNodos(){
		this.setBounds(100, 100, 500, 500);
		this.setLayout(null);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(125, 10, 300, 30);
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
		codigoBuscar.setBounds(110, 50, 180, 30);
		codigoBuscar.setName("codigoBuscar");
		codigoBuscar.setText("");
		codigoBuscar.setVisible(true);
		this.add(codigoBuscar);
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(300, 50, 90,30);
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
		descripcion.setBounds(90, 200, 400, 30);
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
		this.add(botonNuevo);
		
		botonRemover = new JButton();
		botonRemover.setBounds(150, 400, 90, 30);
		botonRemover.setName("botonRemover");
		botonRemover.setText("Remover");
		botonRemover.setVisible(true);
		this.add(botonRemover);
		
		botonSalvar = new JButton();
		botonSalvar.setBounds(250, 400, 90, 30);
		botonSalvar.setName("botonSalvar");
		botonSalvar.setText("Salvar");
		botonSalvar.setVisible(true);
		this.add(botonSalvar);
		
		this.setVisible(true);
		
	}
	
    public static void main(String args[]) {
        System.out.println("Miku daoyou");
		ListaNodos objeto = new ListaNodos();
		objeto.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e){
		//Eventos
	}
}
