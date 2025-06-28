/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.exceptions;

/**
 *
 * @author Nicolle
 */
public class ArquivoMalFormatadoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public ArquivoMalFormatadoException(String errorMessage) {
        super(errorMessage);
    }
}
