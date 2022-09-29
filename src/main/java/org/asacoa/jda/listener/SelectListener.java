package org.asacoa.jda.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import static org.asacoa.jda.component.Component.*;

public class SelectListener extends ListenerAdapter {
    String raid = null;
    String difficulty = null;

    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        String id = event.getComponentId();
        String value = event.getValues().get(0);

        if (id.equals("raid") && !value.equals("도전 가디언/어비스")) {
            raid = event.getValues().get(0);
            event.editComponents(getRaidSelect(raid), getDifficultySelect()).queue();
        } else if (value.equals("도전 가디언/어비스")) {
            raid = event.getValues().get(0);
            event.getChannel().sendMessage("선택된 레이드: " + raid + "/ 난이도: " + difficulty).queue();
        } else if (id.equals("difficulty")) {
            difficulty = event.getValues().get(0);
            event.getChannel().sendMessage("**"+raid+"**공격대가 추가되었습니다").and(
                    event.editComponents(getRaidSelect(raid, true), getDifficultySelect(difficulty, true))).queue();
        }
    }
}
