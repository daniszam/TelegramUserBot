package bot;

import model.User;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.UserService;
import service.UserServiceImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bot extends TelegramLongPollingBot {
    private String name;
    private UserService userService;
    private Logger log = Logger.getLogger(Bot.class.getName());

    private static final String TOKEN="725950208:AAHVP9CyYKg9ExfSdByAM6FGPnsz73-l8QU";
    private static final String NAME="DBUserBot";

    public Bot() {
        userService = new UserServiceImpl();
    }

    public void onUpdateReceived(Update update) {
        this.name = update.getMessage().getText();
        List<User> userList = userService.getUsersByName(name);
        this.sendUser(userList, update.getMessage().getChatId());
    }

    private synchronized void sendUser(List<User> users, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        try {
            sendMessage.setText(users.toString());
            execute(sendMessage);
        }catch (NullPointerException e){
            log.log(Level.FINE, "no such users");
        }catch (TelegramApiException e){
            log.log(Level.SEVERE, "Exception",e);
        }

    }

    @Override
    public String getBotUsername() {
        return NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

}
