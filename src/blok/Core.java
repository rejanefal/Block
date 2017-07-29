/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blok;

import interfaces.ICore;
import interfaces.IGameController;
import interfaces.IPluginController;
import interfaces.IUIController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

    @Override
    public boolean initialize() {
        uiController = new UIController(this);
        gameController = new GameController();
        pluginController = new PluginController();
  
        return uiController.initialize() &&
               gameController.initialize() &&
               pluginController.initialize();
    }

    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IGameController getGameController() {
        return gameController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    private IUIController uiController;
    private IGameController gameController;
    private IPluginController pluginController;
    
}
