/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author DD
 */
public class ValidationErrorException extends RuntimeException {

    private String message;

    public ValidationErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
    
    
}
