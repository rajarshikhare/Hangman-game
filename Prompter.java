import java.io.Console;

public class Prompter{
    private Game mGame;

    public Prompter(Game game){
        mGame = game;
    }


    public void play(){
        while(mGame.getRemainingTries() > 0 && !mGame.isSolved()){
            displayProgress();
            promptForGuesses();
        }
        if(mGame.isSolved()){
            System.out.printf("Congratultions you completed the game with %d tries left",mGame.getRemainingTries());
        } else {
            System.out.printf("Bummer the word was %s",mGame.getAnswer());
        }
    }

    public boolean promptForGuesses(){
        Console console = System.console();
        boolean isHit = false;
        boolean isValidGuess = false;
        while(! isValidGuess){
            String guessAsString = console.readLine(" enter the Guess: ");
            try {
                isHit = mGame.applyGuess(guessAsString);
                isValidGuess = true;
            } catch (IllegalArgumentException iea) {
                console.printf("%s \nplease try again",iea.getMessage());
            }
        }
        return isHit;
    }

    public void displayProgress(){
        System.out.printf("Curent progress \n %s\nYou have %d tries left\n",mGame.getCurrentProgress(),mGame.getRemainingTries());
    }

 }
