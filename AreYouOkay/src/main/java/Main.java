import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String[] args) {
        String token = "fc047eed17c8ab861e65d526385dae732c80c52a2b92bd92acfdbd1ac0469ad6";
        // Log the bot in
        DiscordApi api = new DiscordApiBuilder()
                .setToken(token)
                .login().join();

        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });
    }
}
