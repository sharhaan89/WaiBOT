package waibot;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import java.util.regex.Pattern;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    
    /*
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        
        if(event.getAuthor().isBot())
            return;
        
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException ex) {}

        Random random;
        String dialogues[] = {"sim", "/cc?", "/paintjob?", "/color?", "o"};
        String message = event.getMessage().getContentRaw();
        String name1 = null, name2 = null;
        try {
            name1 = message.substring(0, message.indexOf(' '));
            name2 = message.substring(message.indexOf(' ')+1);
        } catch (Exception e) {}
        
        
        if (message.contains("<@894640226499199006>") || message.contains("wai") || message.contains("Wai")) {
            random = new Random();
            int i = random.nextInt(5);
            event.getChannel().sendMessage(dialogues[i]).queue();
        
        }
               
        else if(name1.equalsIgnoreCase("wai") && name2.equalsIgnoreCase(event.getAuthor().getName())) {
            
            event.getChannel().sendMessage(event.getAuthor().getName()+" Wai").queue();
            event.getChannel().sendMessage("sim").queue();
        }
        
        else if(name2.equalsIgnoreCase("wai") && name1.equalsIgnoreCase(event.getAuthor().getName())) {
            
            event.getChannel().sendMessage("Wai"+event.getAuthor().getName()).queue();
            event.getChannel().sendMessage("sim").queue();
        }
        
        else if(name1.equalsIgnoreCase(event.getAuthor().getAsMention()) && name2.equalsIgnoreCase("<@894640226499199006>")) {
            event.getChannel().sendMessage("<@894640226499199006> "+event.getAuthor().getAsMention()).queue();
            event.getChannel().sendMessage("sim").queue();

        }
        
        else if(name2.equalsIgnoreCase(event.getAuthor().getAsMention()) && name1.equalsIgnoreCase("<@894640226499199006>")) {
            event.getChannel().sendMessage(event.getAuthor().getAsMention()+" <@894640226499199006>").queue();
            event.getChannel().sendMessage("sim").queue();
        }


    }
    */
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        
        if(event.getAuthor().isBot()) {
            return; //no reponse for bot sending messages
        }
        
        String copy = event.getMessage().getContentRaw();
        String msg  = copy.toLowerCase();
        String toSend = "";
        
        System.out.println(copy);
        
        if(msg.contains("sim")) {
            event.getChannel().sendMessage(copy).queue();
        }
        
        if(msg.contains("wai") || msg.contains("<@894640226499199006>") || msg.contains("<@!894640226499199006>")) {
            if(msg.contains(" ")) {
                int spaceIndex = msg.indexOf(" ");
                String userName = event.getAuthor().getName().toLowerCase();
                String userMention = event.getAuthor().getAsMention();
                String name1 = copy.substring(0, spaceIndex + 1);
                String name2 = copy.substring(spaceIndex);
                
                if(msg.contains(userName) || msg.contains(userMention) || msg.contains("<@!"+userMention.substring(msg.indexOf("@") + 1))) {
                    toSend = name2 +" "+ name1;
                } else {
                    toSend = "sim";
                }

            } else {
                String dialogues[] = {"sim", "/cc?", "/paintjob?", "/color?", "o"};
                Random random = new Random();
                toSend = dialogues[random.nextInt(5)];
            }
            
            event.getChannel().sendMessage(toSend).queue();
        }
    }
}
