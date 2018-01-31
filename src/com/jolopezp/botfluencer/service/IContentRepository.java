package com.jolopezp.botfluencer.service;

import com.jolopezp.botfluencer.models.InstaUser;

public interface IContentRepository {
	
	/**
	 * Añade un usuario
	 * @param _username
	 */
	void addUser(InstaUser _username);
	
	/**
	 * Elimina un usuario dado su nombre de usuario
	 * @param _usernameString
	 */
	void removeUser(String _usernameString);
	
	/**
	 * Obtiene el tamaño total del repositorio
	 * @return
	 */
	int getContentSize();
	
}
