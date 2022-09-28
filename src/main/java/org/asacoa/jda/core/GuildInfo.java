package org.asacoa.jda.core;

import net.dv8tion.jda.api.entities.Guild;
import org.asacoa.log.Log;
import org.json.JSONObject;

import java.io.*;

import static org.asacoa.jda.core.BotBuilder.guildInfo;

public class GuildInfo {
    private static final String guildInfoPath = "src/main/resources/json/guild.Json";
    private static final String samplePath = "src/main/resources/json/sample.json";


    public static void Join(Guild guild) {
        saveGuildInfo(guildInfo.put(guild.getId(), readFile(samplePath)));
    }

    public static void Leave(Guild guild) {
    }

    public static JSONObject getGuildInfo() {
        // JSON 파일 읽기
        return readFile(guildInfoPath);
    }

    private static JSONObject readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            sb = new StringBuilder();

            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.info("readFile: guild.json");
        return new JSONObject(sb.toString());
    }


    public static void saveGuildInfo(JSONObject json) {
        Log.info("saveGuildInfo: " + json.toString());
        // JSON 파일 저장
        try {
            File file = new File(guildInfoPath);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json.toString());
            fileWriter.flush();
            fileWriter.close();

            //guildInfo = json;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
