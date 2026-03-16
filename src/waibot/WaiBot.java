package waibot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/**
 *
 * @author Shaan
 */
public class WaiBot {

    public static JDA jda;
    public static String botToken = "";
    
    public static void main(String args[]) throws LoginException {
        
        jda = JDABuilder.createDefault(botToken).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("sim"));
        jda.addEventListener(new Commands());
        
    }
    
}
