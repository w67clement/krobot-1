package com.example.mybot.command;

import fr.litarvan.krobot.command.CommandContext;
import fr.litarvan.krobot.command.CommandHandler;
import fr.litarvan.krobot.command.SuppliedArgument;
import fr.litarvan.krobot.config.ConfigProvider;
import fr.litarvan.krobot.util.Markdown;
import java.util.Map;
import javax.inject.Inject;

public class ExampleCommand implements CommandHandler
{
    @Inject
    private ConfigProvider config; // Automatically filled

    @Override
    public void handle(CommandContext context, Map<String, SuppliedArgument> args)
    {
        String name;

        if (args.containsKey("name"))
        {
            name = args.get("name").getAsString();
        }
        else
        {
            name = config.at("app.defaultName"); // Field 'defaultName' from registered config 'app
        }

        context.getChannel().sendMessage(String.format("Hello %s !", name)).queue(); // Don't forget the .queue()
    }

    public static void handleAdele(CommandContext context, Map<String, SuppliedArgument> args)
    {
        context.getChannel().sendMessage(Markdown.italic("Hello from the other side !!!")).queue();
    }
}
