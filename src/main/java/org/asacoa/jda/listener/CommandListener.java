package org.asacoa.jda.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.asacoa.jda.component.Component;
import org.asacoa.log.Log;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.awt.*;
import java.util.List;

import static org.asacoa.jda.component.Component.*;
import static org.asacoa.jda.core.BotBuilder.guildInfo;
import static org.asacoa.jda.core.BotBuilder.jda;
import static org.asacoa.jda.core.GuildInfo.saveGuildInfo;

public class CommandListener extends ListenerAdapter {

    Component component = new Component();
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
        String ub = event.getSubcommandName();
        List<OptionMapping> args = event.getOptions();
        Guild guild = event.getGuild();
        Channel channel = event.getChannel();

        Log.info("Command: " + command);
        Log.info("CommandSub: " + ub);
        for (OptionMapping arg : args) {
            Log.info("Args: " + arg.getName() + " : " + arg.getAsString());
        }
        Log.info("Guild: " + guild.getName());
        Log.info("Channel: " + channel.getName());

//        String settingChannel = guildInfo.getJSONObject(guild.getId()).getString("channel");

        switch (command) {
            case "도움말":
                event.replyEmbeds(embedBuilder.build()).queue();
                break;
            case "채널설정":
                guildInfo.put(guild.getId(),
                        new JSONObject(guildInfo.get(guild.getId()).toString()).put("channel", channel.getId()));
                saveGuildInfo(guildInfo);
                event.reply("채널이 설정되었습니다.").queue();
                break;
            case "":
                // sendMessage SelectMenu
                //event.replyComponents(getRaidSelect(), getDifficultySelect(true)).setEphemeral(true).queue();

                Log.info(event.getId());
                break;
        }


        // settingChannel and event.getChannel().getId() is same or event.getChannel().getId() is empty channel
        /*if (settingChannel.isEmpty() || command.equals("채널설정") || settingChannel.equals(channel.getId())) {
            switch (command) {
                case "도움말":
                    event.replyEmbeds(embedBuilder.build()).queue();
                    break;
                case "채널설정":
                    guildInfo.put(guild.getId(),
                            new JSONObject(guildInfo.get(guild.getId()).toString()).put("channel", channel.getId()));
                    saveGuildInfo(guildInfo);
                    event.reply("채널이 설정되었습니다.").queue();
                    break;
                case "파티추가":
                    // sendMessage SelectMenu
                    //event.replyComponents(getRaidSelect(), getDifficultySelect(true)).setEphemeral(true).queue();

                    Log.info(event.getId());
                    break;
            }
        } else {
            event.replyEmbeds(new EmbedBuilder()
                    .setColor(Color.RED)
                    .setTitle("명령어 오류")
                    .setDescription("명령어를 사용할 수 없는 채널입니다.")
                    .addField("사용가능 채널", "<#" + settingChannel + ">", true)
                    .build()).setEphemeral(true).queue();
        }*/
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        /*if (event.getAuthor().getId().equals(jda.getSelfUser().getId())) {
            Log.info(event.getMessageId());
        } else if (event.getAuthor().isBot()) {
            Log.info("BOT");
        } else {
            Log.info("send member" + event.getAuthor().getName());
        }*/
    }
}