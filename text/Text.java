package horstmann1chapter.text;


public class Text {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    //ex. 1.8
        public void printNonemptySubstrings(String splitter) {
            String result[] = text.split(splitter);
            for (String str: result){
                if (str.trim().length() != 0) {
                    System.out.println(str);
                }
            }
        }

        //ex.1.9
        public boolean myEquals(String otherText){
            if(text.length() != otherText.length()){
                return false;
            }
            char charsText[] = text.toCharArray();
            char charsOtherText[] = otherText.toCharArray();



            for(int i = 0; i < text.length(); i++){
                if(charsText[i] != charsOtherText[i]){
                    return false;
                }
            }
        return true;
        }
}
