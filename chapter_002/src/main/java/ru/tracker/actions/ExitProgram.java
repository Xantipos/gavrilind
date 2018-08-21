package ru.tracker.actions;


import ru.tracker.input.Input;
import ru.tracker.StartUI;
import ru.tracker.storage.Tracker;

class ExitProgram extends BaseAction {
    private StartUI ui;
    public ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
     this.ui.stop();
    }
}
