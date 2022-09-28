package org.asacoa.jda.listener;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.asacoa.jda.core.GuildInfo;
import org.asacoa.log.Log;
import org.jetbrains.annotations.NotNull;

public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Log.info("Guild Join: " + event.getGuild().getName());
        GuildInfo.Join(event.getGuild());
    }
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
    }

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
    }
}
