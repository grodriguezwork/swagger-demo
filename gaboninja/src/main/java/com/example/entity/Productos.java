package com.example.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "producto")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getProductos",
                                    procedureName = "SP_GET_PRODUCTOS",
        resultClasses = Productos.class)})

public class Productos implements Serializable {
		
	private String idPRODUCTO;
	private String codigoProducto;
	private String nombreProducto;
	private String nombreGenerico;
	
	

}
