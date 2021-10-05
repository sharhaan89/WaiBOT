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
public class Main {

    public static JDA jda;
    
    public static void main(String args[]) throws LoginException {
        
        jda = JDABuilder.createDefault("ODk0NjQwMjI2NDk5MTk5MDA2.YVs8ow.AY92QzjTI5c5y_XNtfIZSoQz2F8").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("sim"));
        jda.addEventListener(new Commands());
        
    }
    
}
