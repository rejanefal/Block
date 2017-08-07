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
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

    private Core(){
        
    }
    
    @Override
    public boolean initialize() {
        gameController = new GameController(this);
        uiController = new UIController(this);
        pluginController = new PluginController();
  
        return  pluginController.initialize() &&
                gameController.initialize() && 
                uiController.initialize();
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
    
     public static Core getInstance(){
        if(core==null)
            core= new Core();
        return core;
    }
    
    private IUIController uiController;
    private IGameController gameController;
    private IPluginController pluginController;
    private static Core core = null;
}
