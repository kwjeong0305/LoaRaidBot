package org.asacoa.jda.listener;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.asacoa.log.Log;
import org.jetbrains.annotations.NotNull;

public class InitListener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        super.onReady(event);
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        Log.info("Guild Activate: " + event.getGuild().getName());
        super.onGuildReady(event);
    }
}
