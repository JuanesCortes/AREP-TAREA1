# Tarea 1 AREP

## Diseño

Cada clase en cada paquete tiene una sola funcion, asi delega el trabajo y permite una mas facil extensibilidad como lo puede ser en el paquete APIURL donde se encuentran clases que hacen uso de la respectiva API e implementan la interfaz URLGen asi permite agregar mas APIs para la consulta.

Tambien se hizo una clase de pruebas para el chaché en su respectivo directorio.

## Running the tests

Test ejecutados con maven.

### Ejemplo de test sencillo para verificar que el cache no guarde dos veces la misma informacion.

```
public void noDeberiaAgregarDobleCache() {
		Cache cache = new Cache();
		try {
			cache.almacenarCache("IBMmonth", "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
			cache.almacenarCache("IBMmonth", "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
		} catch (CacheException e) {
			assertEquals(e.getMessage(),CacheException.EXISTE_CACHE);
		}
	}
```



## Deployment

* [Heroku](https://tarea-1-arep.herokuapp.com/)
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://tarea-1-arep.herokuapp.com/)

## Built With


* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.java.com/es/) - Programing Language


## Authors

* **Juan Esteban Cortés Pérez** - *Tarea de Clase* -


## License

[LICENSE.txt](LICENSE.txt) para mas detalles.
