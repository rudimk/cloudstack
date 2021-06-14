package org.apache.cloudstack.feature;
import com.cloud.utils.component.PluggableService;
import org.apache.cloudstack.framework.config.Configurable;
import org.apache.cloudstack.framework.config.ConfigKey;
import javax.naming.ConfigurationException;
import com.cloud.utils.component.ManagerBase;
import org.apache.cloudstack.api.command.CreateCoffeeCmd;
//import org.apache.cloudstack.api.response.CreateCoffeeRes;
//import org.apache.cloudstack.context.CallContext;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class CoffeeManagerImpl extends ManagerBase implements CoffeeManager, Configurable, PluggableService {

    private static final Logger LOGGER = Logger.getLogger(CoffeeManagerImpl.class);

    public CoffeeManagerImpl() {
        super();
    }
    @Override
    public boolean configure(String name, Map<String, Object> params) throws ConfigurationException {
        super.configure(name, params);
        // Add code on how to handle when this is configured
        LOGGER.debug("Configuring the plugin...");
        return true;
    }

    @Override
    public boolean start() {
        // Add code on how to handle when this is started
        LOGGER.debug("Starting the plugin...");
        return true;
    }

    @Override
    public boolean stop() {
        // Add code on how to handle when this is stopped
        LOGGER.debug("Shutting down the plugin...");
        return true;
    }

    @Override
    public List<Class<?>> getCommands() {
        final List<Class<?>> cmdList = new ArrayList<>();
        cmdList.add(CreateCoffeeCmd.class);
        return cmdList;
    }

    @Override
    public String getConfigComponentName() {
        return "Coffee Manager";
    }

    @Override
    public ConfigKey<?>[] getConfigKeys() {
        return new ConfigKey[]{
            // Add ConfigKeys here
        };
    }

    @Override
    public Hashtable<String, String> createCoffee(CreateCoffeeCmd cmd) {
        Hashtable<String, String> coffee = new Hashtable<String, String>();
        final String uuid = UUID.randomUUID().toString();
        coffee.put("id", uuid);
        coffee.put("name", "Espresso");
        return coffee;
    }
}