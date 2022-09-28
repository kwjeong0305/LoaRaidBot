package org.asacoa.jda.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.asacoa.jda.listener.CommandListener;
import org.asacoa.jda.listener.InitListener;
import org.asacoa.jda.listener.JoinListener;
import org.asacoa.jda.listener.LeaveListener;
import org.asacoa.security.SecController;
import org.json.JSONObject;

import static org.asacoa.jda.core.GuildInfo.getGuildInfo;

public class BotBuilder {
    public static JSONObject guildInfo = getGuildInfo();

    public static void main(String[] args) {
        try {
            JDA jda = JDABuilder
                    .createDefault(new SecController().TokenDecrypt())
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                    .addEventListeners(new InitListener(), new JoinListener(), new CommandListener(), new LeaveListener())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
