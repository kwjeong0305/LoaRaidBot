package org.asacoa.jda.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import static org.asacoa.jda.component.Component.*;

public class SelectListener extends ListenerAdapter {
    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        Message message = event.getMessage();
        event.getInteraction();
        event.getValues();
        if(!event.getValues().get(0).equals("Heroic")) {
            event.editComponents(ActionRow.of(event.editComponents(raidSelect).) , difficulty).queue();
        }
        event.reply("파티가 추가되었습니다").setEphemeral(true).queueAfter(1, TimeUnit.SECONDS);
        // message delete

    }
}
