public class Hangman {
    
    public static void main(String[] args) {
        // Code here:
        if(args[0].length() == 0){
           throw new IllegalArgumentException("please enter an argument"); 
        }
        Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
