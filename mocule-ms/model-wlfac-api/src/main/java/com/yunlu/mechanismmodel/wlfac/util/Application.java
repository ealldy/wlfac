package com.yunlu.mechanismmodel.wlfac.util;

import org.apache.commons.cli.*;

/**
 * @author haozhiqiang 2019/9/18
 **/
public abstract class Application {

    /**
     * 返回用于SpringApplication.run(MainApplication.class, applicationArgs);
     */
    public static String[] getArgs(String[] args) {
        CommandLine cmd;
        Options options = new Options();
        options.addOption("port", "server port", true, "web lisner port, default is 7021");

        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        int serverPort = 7021;
        if (cmd.hasOption("port")) {
            serverPort = Integer.parseInt(cmd.getOptionValue("port"));
        }

        return new String[]{"--server.port=" + serverPort};
    }

}
