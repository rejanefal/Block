/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blok;

import interfaces.IUIController;

/**
 *
 * @author aluno
 */
public class UIController implements IUIController {

    public UIController(Core core) {
        this.core = core;
    }
    
    

    @Override
    public boolean initialize() {
       
        MainWindow mainWindow = new MainWindow((Simulator) core.getGameController().getSimulator(), core.getPluginController());
       
        return true;
    }
    
    private Core core;
}
