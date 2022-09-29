package org.asacoa.jda.command;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    private static List<CommandData> commandData = new ArrayList<>();

    OptionData raidType = new OptionData(OptionType.STRING, "type", "유형", true)
            .addChoice("쿠크세이튼", "쿠크세이튼")
            .addChoice("아브렐슈드", "아브렐슈드")
            .addChoice("일리아칸", "일리아칸")
            .addChoice("도비스도디언", "도비스도디언");

    static OptionData difficulty1 = new OptionData(OptionType.STRING, "difficulty", "난이도", true)
            .addChoice("노말", "노말");
    static OptionData difficulty2 = new OptionData(OptionType.STRING, "difficulty", "난이도", true)
            .addChoice("노말", "노말")
            .addChoice("하드", "하드");

    static OptionData raidMember1 = new OptionData(OptionType.STRING, "member1", "공대원1", true);
    static OptionData raidMember2 = new OptionData(OptionType.STRING, "member2", "공대원2", false);
    static OptionData raidMember3 = new OptionData(OptionType.STRING, "member3", "공대원3", false);
    static OptionData raidMember4 = new OptionData(OptionType.STRING, "member4", "공대원4", false);
    static OptionData raidMember5 = new OptionData(OptionType.STRING, "member5", "공대원5", false);
    static OptionData raidMember6 = new OptionData(OptionType.STRING, "member6", "공대원6", false);
    static OptionData raidMember7 = new OptionData(OptionType.STRING, "member7", "공대원7", false);
    static OptionData raidMember8 = new OptionData(OptionType.STRING, "member8", "공대원8", false);

    static SubcommandData challenge = new SubcommandData("도비스도디언", "도전 가디언/어비스")
            .addOptions(raidMember1, raidMember2, raidMember3, raidMember4);

    static SubcommandData kakulSaydon = new SubcommandData("쿠크세이튼", "쿠크세이튼")
            .addOptions(difficulty1, raidMember1, raidMember2, raidMember3, raidMember4);

    static SubcommandData abreleshud = new SubcommandData("아브렐슈드", "아브렐슈드")
            .addOptions(difficulty2, raidMember1, raidMember2, raidMember3, raidMember4, raidMember5, raidMember6, raidMember7, raidMember8);

    static SubcommandData illiakan = new SubcommandData("일리아칸", "일리아칸")
            .addOptions(difficulty2, raidMember1, raidMember2, raidMember3, raidMember4, raidMember5, raidMember6, raidMember7, raidMember8);

    public static List<CommandData> getCommandList() {
        commandData.add(Commands.slash("도움말", "명령어 정보를 보여줍니다."));
        commandData.add(Commands.slash("채널설정", "명령어를 사용할 채널을 설정합니다."));
        commandData.add(Commands.slash("공격대추가", "공격대를 생성합니다.")
                .addSubcommands(challenge, kakulSaydon, abreleshud, illiakan));
        commandData.add(Commands.slash("공격대삭제", "공격대를 삭제합니다."));
        return commandData;
    }
}