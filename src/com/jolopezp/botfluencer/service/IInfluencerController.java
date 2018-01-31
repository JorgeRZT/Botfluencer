package com.jolopezp.botfluencer.service;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.jolopezp.botfluencer.models.InstaUser;

public interface IInfluencerController {
	
	/**
	 * Inicialización del WebDriver
	 */
	void init();
	
	/**
	 * Login del usuario
	 * @return
	 */
	boolean login();
	
	/**
	 * Logout del usuario
	 */
	void logout();
	
	/**
	 * Seguir a un usuario determinado
	 * @param _username
	 * @return
	 */
	boolean followUser(InstaUser _username);
	
	/**
	 * Dejar de seguir a un usuario determinado
	 * @param username
	 * @return
	 */
	boolean unfollowUser(InstaUser username);
	
	/**
	 * Guardar un usuario en un repositorio
	 * @param _username
	 */
	void saveUserInRepository(InstaUser _username);
	
	/**
	 * Eliminar un usuario de un repositorio
	 * @param _usernameString
	 */
	void removeUserFromRepository(String _usernameString);
	
	/**
	 * Detener el hilo de ejecució unos segundos determinados
	 * @param _seconds
	 */
	void waitSeconds(int _seconds);
	
	/**
	 * Abrir una URL
	 * @param _url
	 */
	void openURL(String _url);
	
	/**
	 * Escribir un contenido en un input dado su selector CSS
	 * @param _keys
	 * @param _cssSelector
	 */
	void writeInput(String _keys, String _cssSelector);
	
	/**
	 * Hacer click en un input dado su selector CSS
	 * @param _cssSelector
	 */
	void clickInput(String _cssSelector);
	
	/**
	 * Establece un usuario logueado en la plataforma
	 * @param _user
	 */
	void setUser(InstaUser _user);
	
	/**
	 * Devuelve el usuario logueado en la plataforma
	 * @return
	 */
	InstaUser getUser();
	
	/**
	 * Establece los usuarios principales
	 * @param _targets
	 */
	void setTargets(List<String> _targets);
	
	/**
	 * Establece si se hará unfollow o no
	 * @param _unfollow
	 */
	void setUnfollowConfiguration(boolean _unfollow);
	
	/**
	 * Inicia el Workflow
	 */
	void initWorkflow();
	
	/**
	 * Obtiene un elemento dado su selector CSS
	 * @param _cssSelector
	 * @return
	 */
	WebElement getElement(String _cssSelector);
	
	/**
	 * Establece la configuración para el trato de cuentas privadas
	 * @param _privateUsers
	 */
	void setPrivatedUsersConfiguration(boolean _privateUsers);
}
