package org.asacoa.jda.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.awt.*;

import static org.asacoa.jda.core.BotBuilder.guildInfo;
import static org.asacoa.jda.core.GuildInfo.saveGuildInfo;

public class CommandListener extends ListenerAdapter {
    EmbedBuilder embedBuilder = new EmbedBuilder()
            .setColor(Color.GREEN)
            .setTitle("명령어 정보")
            .setDescription("명령어 정보를 보여줍니다.")
            .addBlankField(false)
            .addField("명령어", "설명", true)
            .addField("", "!!명령어", true);

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        Guild guild = event.getGuild();
        Member member = event.getMember();

        switch (command) {
            case "도움말":
                event.replyEmbeds(embedBuilder.build()).queue();
                break;
            case "채널설정":
                guildInfo.put(guild.getId(),
                        new JSONObject(guildInfo.get(guild.getId()).toString()).put("channel", event.getChannel().getId()));
                saveGuildInfo(guildInfo);
                event.reply("채널이 설정되었습니다.").queue();
                break;
            case "test":
                break;
        }
    }
}