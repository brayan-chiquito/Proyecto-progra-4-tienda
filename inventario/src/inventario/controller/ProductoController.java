package inventario.controller;

import java.util.List;

import inventario.dao.ProductoDao;
import inventario.modelo.Producto;

public class ProductoController {
	
	private ProductoDao productoDao;;
	
	public ProductoController() {
		this.productoDao = new ProductoDao();
	}
	
	
	public int modificar(String nombre, String descripcion, String tamano, String color, String proveedor, Integer precio, Integer id) {
		return productoDao.modificar(nombre,descripcion,tamano,color,proveedor,precio,id);
	}

	public int eliminar(Integer id) {
		return productoDao.eliminar(id);
	}

	public List<Producto> listar() {
		
		return productoDao.listar();
	}

    public void guardar(Producto producto) {
		productoDao.guardar(producto);
	}

}
