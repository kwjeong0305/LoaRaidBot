package org.asacoa.jda.listener;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.asacoa.log.Log;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static org.asacoa.jda.command.CommandList.getCommandList;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        super.onReady(event);
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = getCommandList();
        event.getGuild().updateCommands().addCommands(commandData).queue();
        Log.info("Guild Activate: " + event.getGuild().getName());
        super.onGuildReady(event);
    }
}
