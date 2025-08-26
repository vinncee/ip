public class ExitCommand extends Command{

    @Override 
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("byeee see u in the leaf village again!");
        ui.showLine();
    }

    @Override
    public boolean isExit() {
        return true;
    }
    
}
