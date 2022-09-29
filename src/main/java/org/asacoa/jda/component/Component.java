package org.asacoa.jda.component;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;

import java.util.Collections;

public class Component {

    private static Button button = Button.primary("Add Raid", "레이드 추가");
    private static SelectOption raidSelectOption1 = SelectOption.of("쿠크세이튼", "쿠크세이튼");
    private static SelectOption raidSelectOption2 = SelectOption.of("아브렐슈드", "아브렐슈드");
    private static SelectOption raidSelectOption3 = SelectOption.of("일리아칸", "일리아칸");
    private static SelectOption raidSelectOption4 = SelectOption.of("도전 시리즈", "도전 가디언/어비스");

    private static SelectOption difficultySelectOption1 = SelectOption.of("노말", "노말");
    private static SelectOption difficultySelectOption2 = SelectOption.of("하드", "하드");


    public static LayoutComponent getRaidSelect() {
        return ActionRow.of(
                SelectMenu.create("raid")
                        .setPlaceholder("Select Menu")
                        .addOptions(raidSelectOption1, raidSelectOption2, raidSelectOption3, raidSelectOption4)
                        .build()
        );
    }

    public static LayoutComponent getRaidSelect(String defaultValue) {
        return ActionRow.of(
                SelectMenu.create("raid")
                        .setPlaceholder("Select Menu")
                        .addOptions(raidSelectOption1, raidSelectOption2, raidSelectOption3, raidSelectOption4)
                        .setDefaultValues(Collections.singletonList(defaultValue))
                        .setDisabled(false)
                        .build()
        );
    }

    public static LayoutComponent getRaidSelect(String defaultValue, Boolean isDisabled) {
        return ActionRow.of(
                SelectMenu.create("raid")
                        .setPlaceholder("Select Menu")
                        .addOptions(raidSelectOption1, raidSelectOption2, raidSelectOption3, raidSelectOption4)
                        .setDefaultValues(Collections.singletonList(defaultValue))
                        .setDisabled(isDisabled)
                        .build()
        );
    }

    public static LayoutComponent getDifficultySelect() {
        return ActionRow.of(
                SelectMenu.create("difficulty")
                        .setPlaceholder("Select Menu")
                        .addOptions(difficultySelectOption1, difficultySelectOption2)
                        .build()
        );
    }

    public static LayoutComponent getDifficultySelect(boolean isDisabled) {
        return ActionRow.of(
                SelectMenu.create("difficulty")
                        .setPlaceholder("Select Menu")
                        .addOptions(difficultySelectOption1, difficultySelectOption2)
                        .setDisabled(isDisabled)
                        .build()
        );
    }
    public static LayoutComponent getDifficultySelect(String defaultValue) {
        return ActionRow.of(
                SelectMenu.create("difficulty")
                        .setPlaceholder("Select Menu")
                        .addOptions(difficultySelectOption1, difficultySelectOption2)
                        .setDefaultValues(Collections.singletonList(defaultValue))
                        .setDisabled(false)
                        .build()
        );
    }

    public static LayoutComponent getDifficultySelect(String defaultValue, Boolean isDisabled) {
        return ActionRow.of(
                SelectMenu.create("difficulty")
                        .setPlaceholder("Select Menu")
                        .addOptions(difficultySelectOption1, difficultySelectOption2)
                        .setDefaultValues(Collections.singletonList(defaultValue))
                        .setDisabled(isDisabled)
                        .build()
        );
    }
}
