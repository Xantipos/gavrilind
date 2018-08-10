package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.StartUI;
import ru.tracker.storage.Tracker;

public class ExitProgram implements UserAction {
private StartUI ui;

  ExitProgram(StartUI ui) {
    this.ui = ui;
  }

  @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
     this.ui.stop();
    }

    @Override
    public String info() {
        return "6 Exit Program.";
    }
}