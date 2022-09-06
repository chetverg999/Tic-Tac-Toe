public class ComputerPlayer implements Runnable {
    PlayersActions playersActions = new PlayersActions();

    @Override
    public void run() {
        playersActions.computerPlayer();
    }
}