package Enums


public enum Visibility {
    PRIVATE,PUBLIC
    public static Visibility toEnum(String str){
        if(str.equalsIgnoreCase("PUBLIC"))
            return Visibility.PUBLIC
        else
            return Visibility.PRIVATE
    }



}
