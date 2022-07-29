package ch.luca.cubeslide.coinsapi;

import ch.luca.cubeslide.coinsapi.config.MySQLConfig;
import ch.luca.cubeslide.coinsapi.mysql.MySQL;
import ch.luca.cubeslide.coinsapi.mysql.repository.CoinsRepository;
import lombok.Getter;
import net.cubespace.Yamler.Config.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CoinsAPI extends JavaPlugin {

    @Getter
    private static CoinsAPI instance;

    @Getter
    private MySQL coinsMySQL;

    @Getter
    private CoinsRepository coinsRepository;

    private MySQLConfig mySQLConfig;

    @Getter
    private static String prefix = "§3CubeSlide §8» §7";

    @Override
    public void onEnable() {
        instance = this;
        try {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdir();
            }
            this.mySQLConfig = new MySQLConfig(new File(this.getDataFolder(), "mysql.yml"));
            this.mySQLConfig.init();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        // Init mysql connection
        this.coinsMySQL = new MySQL(this.mySQLConfig.getHost(), this.mySQLConfig.getDatabase(), this.mySQLConfig.getUser(),
                this.mySQLConfig.getPassword(), this.mySQLConfig.getPort());

    }

}
