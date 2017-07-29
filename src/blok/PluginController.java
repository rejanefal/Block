package blok;

import interfaces.IPluginController;
import interfaces.IPlugin;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginController implements IPluginController {
    
    private ArrayList<IPlugin> pluginsCarregados = new ArrayList<>();
    @Override
    public boolean initialize() {

        File currentDir = new File("./plugins");
        String []plugins = currentDir.list();
       
        URL[] jars = new URL[plugins.length];
        
        for (int i = 0; i < plugins.length; i++){
            try {
                jars[i] = (new File("./plugins/" + plugins[i])).toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
        }
        URLClassLoader ulc = new URLClassLoader(jars);
        
        for (String plugin : plugins) {
            
            String pluginName = plugin.split("\\.")[0];
            String packageName = pluginName.toLowerCase();
            try {
                IPlugin factory = (IPlugin) Class.forName(packageName + "." + pluginName, true, ulc).newInstance();
                if (factory != null) {
                    pluginsCarregados.add(factory);
                    System.out.println(factory.msgPlugin());
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException ex) {
                System.out.println("Erro ao tentar Carregar o plugin" + pluginName);
            } 
        }   
        return true;
    }

    public ArrayList<IPlugin> getPluginsCarregados() {
        return pluginsCarregados;
    }
}
