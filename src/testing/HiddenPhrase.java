package testing;

public class HiddenPhrase {
	private String word;
	private String result;
	public HiddenPhrase(String w) {
		word = w;
		result = "";
	}

	public String getFeedback(String guess){
		result = "";
		for (int i = 0; i < guess.length(); i ++){
			if (word.indexOf(guess.charAt(i)) ==  i){
				result += guess.charAt(i);
			}
			else if(word.indexOf(guess.charAt(i)) != -1){
				result += "+";
			}
			else if(word.indexOf(guess.charAt(i)) == -1){
				result += "*";
			}
		}
		return result;
	}
}
