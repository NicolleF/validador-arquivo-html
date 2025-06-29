/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author Nicolle
 */
public class MalformedFileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MalformedFileException(String errorMessage) {
        super(errorMessage);
    }
}
