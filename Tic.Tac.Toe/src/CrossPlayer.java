public class CrossPlayer implements Runnable {
    PlayersActions playersActions = new PlayersActions();

    @Override
    public void run() {
        playersActions.crossPlayer();
    }
}
