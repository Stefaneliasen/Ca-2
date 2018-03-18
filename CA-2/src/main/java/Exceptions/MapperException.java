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
public class MapperException extends Exception {

    /**
     * Creates a new instance of <code>MapperException</code> without detail
     * message.
     */
    public MapperException() {
    }

    /**
     * Constructs an instance of <code>MapperException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MapperException(String msg) {
        super(msg);
    }
}
