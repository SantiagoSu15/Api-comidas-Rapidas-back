package com.equipoMorado.refuerzoMorado.Util.Excepciones.Ex;

public class ProductoFueraDeStockException extends RuntimeException {
    public ProductoFueraDeStockException(String message) {
        super(message);
    }
}
