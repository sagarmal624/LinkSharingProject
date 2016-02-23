package com.ttnd.LinkSharing

/**
 * Created by sagar on 2/22/16.
 */
enum Seriousness {
    SERIOUS,VERY_SERIOUS,CASUAL
    public static Seriousness getSeriousness(String str){
        if(str.equalsIgnoreCase("serious"))
        {
            return Seriousness.SERIOUS
        }else
        {
 return Seriousness.VERY_SERIOUS
        }
    }

}