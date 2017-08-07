/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blok;

import interfaces.IGameController;

/**
 *
 * @author aluno
 */
public class GameController implements IGameController{

    public GameController(Core core) {
        this.core = core;
    }
    

    @Override
    public boolean initialize() {
       simulator = new Simulator();
        //core.getUIController()
        return true;
    }
    
    private Core core;
    private Simulator simulator;

    @Override
    public Object getSimulator() {
        return simulator;
    }
    
    

}
