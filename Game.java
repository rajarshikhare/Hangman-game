public class Game{

    private String mAnswer;
    private String mHits;
    private String mMisses;
    private static final int MAX_MISSES = 7;

    public Game(String answer) {
        mAnswer = answer;
        mHits = "";
        mMisses = "";
    }


    private char validateGuess(char letter) {
        if(!Character.isLetter(letter)) {
            throw new IllegalArgumentException("enter a letter");
        }
        letter = Character.toLowerCase(letter);
        if(mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
            throw new IllegalArgumentException(letter + " is already guessed");
        }
        if( mHits.length() == mAnswer.length()) {
            throw new IllegalArgumentException("Game complete you won!!!");
        }
        return letter;
    }


    public boolean applyGuess(String letter) {
        if( letter.length() == 0 ) {
            throw new IllegalArgumentException("No letter found");
        }
        return applyGuess(letter.charAt(0));
    }


    public boolean applyGuess(char letter) {
        letter = validateGuess(letter);
        boolean isHit = (mAnswer.indexOf(letter) >= 0);
        if(isHit){
            mHits += letter;
        } else {
            mMisses += letter;
        }
        return isHit;
    }

    public String getCurrentProgress() {
        String display = "";
        for(char letter: mAnswer.toCharArray()) {
            if(mHits.indexOf(letter) >= 0) {
                display += letter;
            } else {
                display += '-';
            }
        }
        return display;
    }

    public int getRemainingTries() {
        return MAX_MISSES - mMisses.length();
    }

    public boolean isSolved(){
        return getCurrentProgress().indexOf("-") == -1;
    }

    public String getAnswer(){
        return mAnswer;
    }
}
