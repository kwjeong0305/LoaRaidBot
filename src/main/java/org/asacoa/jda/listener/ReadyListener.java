package org.asacoa.jda.listener;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.*;
import org.asacoa.log.Log;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        super.onReady(event);
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("도움말", "명령어 정보를 보여줍니다."));
        commandData.add(Commands.slash("채널설정", "명령어를 사용할 채널을 설정합니다."));

        /*
        OptionData raidType = new OptionData(OptionType.STRING, "유형", "유형", true)
                .addChoice("쿠크세이튼", "Kakul-Saydon")
                .addChoice("아브렐슈드", "Abrelshud")
                .addChoice("일리아칸", "Illiakan");
        OptionData difficulty = new OptionData(OptionType.STRING, "난이도", "난이도", true)
                .addChoice("노말", "normal")
                .addChoice("하드", "hard");
        OptionData raidName = new OptionData(OptionType.STRING, "레이드이름", "레이드 이름", true);*/

        commandData.add(Commands.slash("파티추가", "신규 파티를 추가합니다"));
        commandData.add(Commands.slash("파티삭제", "기존 파티를 삭제합니다"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
        Log.info("Guild Activate: " + event.getGuild().getName());
        super.onGuildReady(event);
    }
}
