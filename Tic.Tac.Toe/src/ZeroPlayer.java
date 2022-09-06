public class ZeroPlayer implements Runnable {
    PlayersActions playersActions = new PlayersActions();

    @Override
    public void run() {
        playersActions.zeroPlayer();
    }
}