package com.iscod.coworkia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.yaml.snakeyaml.events.Event.ID;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EntityDontExistException extends RuntimeException {
	
	public EntityDontExistException(Object id) {
		super("Element introuvable ou inexistant (id=" + id + ").");
	}
	
}
