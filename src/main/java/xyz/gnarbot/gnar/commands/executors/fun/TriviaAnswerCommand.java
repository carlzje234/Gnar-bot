package xyz.gnarbot.gnar.commands.executors.fun;

import xyz.gnarbot.gnar.commands.handlers.Command;
import xyz.gnarbot.gnar.commands.handlers.CommandExecutor;
import xyz.gnarbot.gnar.utils.Note;
import xyz.gnarbot.gnar.utils.TriviaQuestions;

import java.util.List;

@Command(aliases = "answer")
public class TriviaAnswerCommand extends CommandExecutor {
    @Override
    public void execute(Note note, List<String> args) {
        if (!TriviaQuestions.isSetup()) {
            TriviaQuestions.init();
        }

        try {
            note.respond().info(TriviaQuestions.getAnswer(Integer.valueOf(args.get(0)))).queue();
        } catch (Exception e) {
            note.respond().error("Please enter a number.").queue();
        }
    }

}
