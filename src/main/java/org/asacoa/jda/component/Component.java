package org.asacoa.jda.component;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

public class Component {
    //add button component
    public LayoutComponent actionButton = ActionRow.of(
            Button.primary("button1", "Button1"),
            Button.secondary("button2", "Button2"),
            Button.success("button3", "Button3"),
            Button.danger("button4", "Button4"),
            Button.link("https://github.com/kwjeong0305/LoaRaidBot", "Button5"));

    //add Select in select Component
    public LayoutComponent raidSelect = ActionRow.of(
            SelectMenu.create("select1")
                    .setPlaceholder("Select Menu")
                    .addOption("쿠크세이튼", "Kakul-Saydon")
                    .addOption("아브렐슈드", "Abrelshud")
                    .addOption("일리아칸 ", "Illiakan")
                    .addOption("도디언 도비스", "Heroic")
                    .build()
    );
}
