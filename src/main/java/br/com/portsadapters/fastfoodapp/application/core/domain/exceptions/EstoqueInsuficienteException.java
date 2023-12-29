package br.com.portsadapters.fastfoodapp.application.core.domain.exceptions;

public class EstoqueInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 7342055796767612656L;

	public EstoqueInsuficienteException(String message) {
        super(message);
    }

    public EstoqueInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }
}
