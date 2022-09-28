package org.asacoa.jda.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.asacoa.jda.listener.*;
import org.asacoa.log.Log;
import org.asacoa.security.SecController;
import org.json.JSONObject;

import static org.asacoa.jda.core.GuildInfo.getGuildInfo;

public class BotBuilder {
    public static JSONObject guildInfo = getGuildInfo();

    public static JDA jda;

    public static void main(String[] args) {
        try {
            jda = JDABuilder
                    .createDefault(new SecController().TokenDecrypt())
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                    .addEventListeners(new ReadyListener(), new CommandListener(), new JoinListener(), new LeaveListener(), new ButtonListener(), new SelectListener())
                    .build();
        } catch (Exception e) {
            Log.error(e.toString());
            e.printStackTrace();
        }
    }
}
