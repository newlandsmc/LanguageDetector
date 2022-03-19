package com.semivanilla.languagedetector.listener;

import com.semivanilla.languagedetector.LanguageDetector;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class PlayerChatListener implements Listener {

    private final LanguageDetector plugin;

    PlayerChatListener(@NotNull LanguageDetector plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerAsyncChat(AsyncChatEvent event){
        if(event.isCancelled())
            return;

        if(plugin.getFileHandler().getWhitelistFile().isPlayerWhitelisted(event.getPlayer().getName()))
            return;

        final String message = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());

        if(plugin.getRegexHandler().isRegexPassed(message))
            return;



    }

}
