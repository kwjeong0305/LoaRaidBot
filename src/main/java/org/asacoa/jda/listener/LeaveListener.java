package org.asacoa.jda.listener;

import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.asacoa.log.Log;
import org.jetbrains.annotations.NotNull;

public class LeaveListener extends ListenerAdapter {
    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        Log.info("Guild Leave: " + event.getGuild().getName());
    }

}
