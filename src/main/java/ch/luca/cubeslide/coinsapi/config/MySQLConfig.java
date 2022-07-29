package ch.luca.cubeslide.coinsapi.config;

import lombok.Getter;
import net.cubespace.Yamler.Config.Path;
import net.cubespace.Yamler.Config.YamlConfig;

import java.io.File;

@Getter
public class MySQLConfig extends YamlConfig {

    @Path("mysql.host")
    private String host = "localhost";

    @Path("mysql.database")
    private String database = "database";

    @Path("mysql.user")
    private String user = "user";

    @Path("mysql.password")
    private String password = "password";

    @Path("mysql.port")
    private int port = 3306;

    public MySQLConfig( File file ) {
        this.CONFIG_FILE = file;
    }
}